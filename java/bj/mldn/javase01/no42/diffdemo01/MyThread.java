package bj.mldn.javase01.no42.diffdemo01;

public class MyThread extends Thread {// 继承Thread类

	private int ticket = 5; // 一共才5张票

	public void run() {// 覆写run()方法

		for ( int i = 0; i < 50; i++ ) {// 表示循环10次

			if ( this.ticket > 0 ) {

				System.out.println( "卖票：ticket = " + this.ticket-- );
			}
		}

	}

}
