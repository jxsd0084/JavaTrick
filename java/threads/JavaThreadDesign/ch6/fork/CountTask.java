package threads.JavaThreadDesign.ch6.fork;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask< Long > {

	private static final int THRESHOLD = 10000;

	private long start;
	private long end;

	public CountTask( long start, long end ) {

		this.start = start;
		this.end = end;
	}

	public Long compute() {

		long    sum        = 0;
		boolean canCompute = ( end - start ) < THRESHOLD;

		if ( canCompute ) {

			for ( long i = start; i <= end; i++ ) {

				sum += i;
			}

		} else {

			//分成100个小任务
			long step = ( start + end ) / 100;
			long pos  = start;

			ArrayList< CountTask > subTasks = new ArrayList< CountTask >();

			for ( int i = 0; i < 100; i++ ) {

				long lastOne = pos + step;

				if ( lastOne > end ) {

					lastOne = end;
				}

				CountTask subTask = new CountTask( pos, lastOne );

				pos += step + 1;

				subTasks.add( subTask );

				subTask.fork();
			}

			for ( CountTask t : subTasks ) {

				sum += t.join();
			}

		}

		return sum;
	}

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) {

		ForkJoinPool forkJoinPool = new ForkJoinPool();

		CountTask task = new CountTask( 0, 20000L );

		ForkJoinTask< Long > result = forkJoinPool.submit( task );

		try {

			long res = result.get();

			System.out.println( "sum=" + res );

		} catch ( InterruptedException e ) {
			e.printStackTrace();

		} catch ( ExecutionException e ) {
			e.printStackTrace();

		}

	}

}

/*

Fork and Join: Java也可以轻松地编写并发程序

URL:    http://ifeve.com/fork-and-join-java/

在应用中要实现最大性能的一个重要技术手段是将密集的任务分隔成多个可以并行执行的块，以便可以最大化利用计算能力。

*/