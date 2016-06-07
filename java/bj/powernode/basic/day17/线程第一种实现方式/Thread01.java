package bj.powernode.basic.day17.线程第一种实现方式;


/*

	线程的实现包括两种方式：
		第一种方式：写一个线程类继承Thread,重写run方法.

*/
public class Thread01 extends Thread {

	public void run() {

		System.out.println( "Thread01's run method invoke." );
	}

}
