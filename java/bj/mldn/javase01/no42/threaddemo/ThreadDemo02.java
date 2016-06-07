package bj.mldn.javase01.no42.threaddemo;

public class ThreadDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		MyThread mt1 = new MyThread( "线程A" );
		MyThread mt2 = new MyThread( "线程B" );

		mt1.start(); // 调用线程体
		mt2.start(); // 调用线程体

	}

}
