package bj.bigData.HBase.ex03.writer.bean;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FileCache {

	private static BlockingQueue< FileInfo > fileInfos = new ArrayBlockingQueue< FileInfo >( 1000000 );

	public static synchronized FileInfo take() throws InterruptedException {

		return fileInfos.take();
	}

	public static void put( FileInfo fi ) {

		try {
			FileCache.fileInfos.put( fi );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
	}
}
