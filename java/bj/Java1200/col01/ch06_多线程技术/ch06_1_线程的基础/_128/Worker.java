package bj.Java1200.col01.ch06_多线程技术.ch06_1_线程的基础._128;

public class Worker implements Runnable {

	public void run() {

		for ( int i = 0; i < 5; i++ ) {
			System.out.println( "《Java编程词典》第" + i + "次更新！" );// 用户线程用来输出一些语句
		}
	}
}
