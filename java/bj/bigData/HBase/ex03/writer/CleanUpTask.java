package bj.bigData.HBase.ex03.writer;

import com.boco.DataPlatform.hbase.writer.bean.FileCache;
import com.boco.DataPlatform.hbase.writer.bean.FileInfo;

import java.util.concurrent.CountDownLatch;

public class CleanUpTask implements Runnable {

	private CountDownLatch latch;

	public CleanUpTask( CountDownLatch latch ) {

		this.latch = latch;
	}

	@Override
	public void run() {

		try {
			latch.await();
			FileInfo info = new FileInfo();
			info.setFinished( true );
			FileCache.put( info );
		} catch ( InterruptedException e ) {
			
			e.printStackTrace();
		}
	}

}
