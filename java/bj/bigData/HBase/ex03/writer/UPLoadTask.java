package bj.bigData.HBase.ex03.writer;

import com.boco.DataPlatform.hbase.writer.bean.FileCache;
import com.boco.DataPlatform.hbase.writer.bean.FileInfo;
import com.boco.DataPlatform.hbase.writer.utils.XmlFtpUtils;
import com.jcraft.jsch.ChannelSftp;

import java.io.File;

public class UPLoadTask implements Runnable {

	private ChannelSftp sftp;

	public UPLoadTask( ChannelSftp sftp ) {

		this.sftp = sftp;
	}

	public void run() {

		while ( true ) {
			FileInfo fi;
			try {
				fi = FileCache.take();
				if ( fi.isFinished() ) {
					break;
				}
				File f = fi.getFile();
				XmlFtpUtils.upload( f, sftp );
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		}
		XmlFtpUtils.closeFtp( sftp );
	}

}
