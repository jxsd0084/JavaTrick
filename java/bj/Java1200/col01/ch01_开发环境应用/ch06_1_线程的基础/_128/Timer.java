package bj.Java1200.col01.ch01_开发环境应用.ch06_1_线程的基础._128;

public class Timer implements Runnable {

	public void run() {

		long currentTime = System.currentTimeMillis();// 获得系统当前时间
		long processTime = 0;// 设置系统运行时间为0
		while ( true ) {// 如果系统运行时间发生变化就输出
			if ( ( System.currentTimeMillis() - currentTime ) > processTime ) {
				processTime = System.currentTimeMillis() - currentTime;
				System.out.println( "程序运行时间：" + processTime );
			}
		}
	}
}
