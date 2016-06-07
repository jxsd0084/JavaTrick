package bj.bigData.HBase.ex03.writer.utils;

import com.boco.DataPlatform.utils.ConfigUtils;
import com.jcraft.jsch.*;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class XmlFtpUtils {

	private static final Properties prop = ConfigUtils
			.getConfig( "/config/AccessLogs_Xml.properties" );

	private static final String FTP_SERVER_HOST = prop.getProperty( "ftp.host" );
	private static final int    FTP_SERVER_PORT = Integer.parseInt( prop.getProperty( "ftp.port" ) );
	private static final String HOST_NAME       = prop.getProperty( "ftp.hostname" );
	private static final String PASSWD          = prop.getProperty( "ftp.passwd" );
	private static final String DEFAULT_DIR     = prop.getProperty( "ftp.default.dir" );
	
	
	/**
	 * 连接sftp服务器
	 */
	public static ChannelSftp connectAndcd2defaultDir() {

		ChannelSftp sftp = null;
		try {
			JSch jsch = new JSch();
			System.out.println( "connct ftp:" + FTP_SERVER_HOST );
			Session sshSession = jsch.getSession( HOST_NAME, FTP_SERVER_HOST, FTP_SERVER_PORT );
			System.out.println( "Session created." );
			sshSession.setPassword( PASSWD );
			Properties sshConfig = new Properties();
			sshConfig.put( "StrictHostKeyChecking", "no" );
			sshSession.setConfig( sshConfig );
			sshSession.connect();
			System.out.println( "Session connected." );
			System.out.println( "Opening Channel." );
			Channel channel = sshSession.openChannel( "sftp" );
			channel.connect();
			sftp = ( ChannelSftp ) channel;
			sftp.cd( DEFAULT_DIR );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return sftp;
	}
	
	/**
	 * @param uploadFile 要上传的文件
	 * @throws Exception
	 */
	public static void upload( File file, ChannelSftp sftp ) {

		if ( sftp == null ) {
			sftp = connectAndcd2defaultDir();
		}
		try {
			//上传到默认的目录下
			sftp.put( file.getPath(), DEFAULT_DIR );
			File f = new File( file.getPath().replace( ".xml", ".ok" ) );
			f.createNewFile();
			sftp.put( f.getPath(), DEFAULT_DIR );
			file.delete();
			f.delete();
		} catch ( SftpException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public static void closeFtp( ChannelSftp sftp ) {

		if ( sftp == null ) {
			return;
		}
		sftp.disconnect();
		sftp.exit();
		sftp = null;
	}

}
