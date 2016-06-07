package bj.JavaSpecialForces.chapter05.tools;

import java.util.Random;
import java.util.concurrent.*;

public class CompletionServiceTest {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws InterruptedException, ExecutionException {
		final Random                random            = new Random();
		ExecutorService             executorService   = Executors.newFixedThreadPool( 10 );
		CompletionService< String > completionService = new ExecutorCompletionService< String >( executorService );
		for ( int i = 0; i < 100; i++ ) {
			final int num = i;
			completionService.submit( new Callable< String >() {
				public String call() {
					try {
						Thread.sleep( ( random.nextLong() ) & 5000 );
					} catch ( InterruptedException e ) {
						e.printStackTrace();
					}
					return "a" + num;
				}
			} );
		}
		for ( int i = 0; i < 100; i++ ) {
			Future< String > f = completionService.take();
			System.out.println( f.get() );
		}
		executorService.shutdown();
	}

}
