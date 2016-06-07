package bj.powernode.basic.day18.review_day17;

public class Thread01 extends Thread {

	public void run() {

		System.out.println( "Thread01 run execute" );
	}

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		Thread01 t = new Thread01();
		t.start();

	}

}
