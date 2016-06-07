package bj.fxkBasic.Proxy.thread;

import java.util.concurrent.*;

public class FutureTest {

	public static void main( String[] args ) {

		ExecutorService service = Executors.newSingleThreadExecutor();
		class MyCallable implements Callable< String > {

			public String call() throws Exception {

				for ( int i = 0; i < 10; i++ ) {
					Thread.sleep( 1000 );
					System.out.println( "calling " + i );
				}

				return "hello";
			}
			
		}
		//Future<String> future = service.submit(new MyCallable());
		class MyCallable2< T > implements Callable< T > {

			public T call() throws Exception {

				for ( int i = 0; i < 10; i++ ) {
					Thread.sleep( 1000 );
					System.out.println( "calling " + i );
				}
				return null;
			}
		}
		
		Future< String > future = service.submit( new Callable< String >() {
			public String call() throws Exception {

				for ( int i = 0; i < 10; i++ ) {
					Thread.sleep( 1000 );
					System.out.println( "calling " + i );
				}
				return "hello";
			}
			
		} );
		
		try {
			//���������������ͣʧ�ܣ����ܿ��������ӡ��calling��
			//Thread.sleep(2000);			
			//future.cancel(false);
			//System.out.println(future.isCancelled());
			if ( true ) {
				System.out.println( future.get() );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		System.out.println( "end!" );
		service.shutdown();
		
		CompletionService< String > ecs = new ExecutorCompletionService< String >(
				Executors.newSingleThreadExecutor()
		);
		for ( int i = 0; i < 10; i++ ) {
			ecs.submit( new MyCallable() );
		}
		try {
			for ( int i = 0; i < 10; i++ ) {
				Future< String > future2 = ecs.take();
				System.out.println( future2.get() );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

}
