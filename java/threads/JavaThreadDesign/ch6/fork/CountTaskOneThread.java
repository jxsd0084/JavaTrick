package threads.JavaThreadDesign.ch6.fork;

public class CountTaskOneThread {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) {

		long sum = 0;

		for ( long i = 1; i <= 2000000000L; i++ ) {

			sum += i;
		}

		System.out.println( sum );
	}

}
