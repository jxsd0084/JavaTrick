package bj.bigData.HBase.ex03.writer.constant;

import com.boco.DataPlatform.utils.ConfigUtils;

import java.util.Properties;

public class XmlConstants {

	private static final Properties prop                = ConfigUtils.getConfig( "/config/AccessLogs_Xml.properties" );
	//FTP 相關配置
	public static final  String     XML_FTP_SERVER_HOST = prop.getProperty( "ftp.host" );
	public static final  int        XML_FTP_SERVER_PORT = Integer.parseInt( prop
			.getProperty( "ftp.port" ) );
	public static final  String     XML_FTP_HOST_NAME   = prop.getProperty( "ftp.hostname" );
	public static final  String     XML_FTP_PASSWD      = prop.getProperty( "ftp.passwd" );
	public static final  String     XML_FTP_DEFAULT_DIR = prop.getProperty( "ftp.default.dir" );
	
	public static final String XMl_HEAD = prop.getProperty( "xml.head" );
	public static final String XML_ROOT = prop.getProperty( "xml.root" );
	
	public static final int    XML_MAX_LOGNODE_SIZE = Integer.parseInt( prop.getProperty( "xml.max.log.size" ) );
	public static final String XMl_BASE_PATH        = prop.getProperty( "xml.out.path" );

}
