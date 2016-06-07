package bj.bigData.HBase.ex03.writer;

import com.boco.DataPlatform.hbase.writer.utils.XmlFtpUtils;
import com.jcraft.jsch.ChannelSftp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class XmlClient {

	public static void ResultToXml( XMLExportResult rs ) {
		// 得到总的记录条数
		int size = rs.getSize();
		// 每个xml 中 最多能放 log的条数  计算需生成几个xml文件
		int n = size / XmlFactory.MAX_LOGNODE_SIZE;
		int l = size % XmlFactory.MAX_LOGNODE_SIZE;
		if ( n > 0 && l == 0 ) {
			n--; // 确保留有一个标记结束的文件
		}
		CountDownLatch latch = new CountDownLatch( n + 1 );
		ChannelSftp    sftp  = XmlFtpUtils.connectAndcd2defaultDir();
		ThreadPoolExecutor xmlPool = new ThreadPoolExecutor( 10,
				10, 3, TimeUnit.SECONDS,
				new ArrayBlockingQueue< Runnable >( 100 ),
				new ThreadPoolExecutor.DiscardOldestPolicy() );
		ThreadPoolExecutor ftpPool = new ThreadPoolExecutor( 10,
				10, 3, TimeUnit.SECONDS,
				new ArrayBlockingQueue< Runnable >( 100 ),
				new ThreadPoolExecutor.DiscardOldestPolicy() );
		// 非结尾文件        
		for ( int i = 0; i < n; i++ ) {
			xmlPool.execute( new XmlFactory( rs, i, false, latch ) );
		}
		// 结尾文件
		xmlPool.execute( new XmlFactory( rs, n, true, latch ) );
		xmlPool.execute( new CleanUpTask( latch ) );
		ftpPool.execute( new UPLoadTask( sftp ) );
		xmlPool.shutdown();
		ftpPool.shutdown();
	}
}
