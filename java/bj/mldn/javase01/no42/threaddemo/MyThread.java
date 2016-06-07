package bj.mldn.javase01.no42.threaddemo;

public class MyThread extends Thread {

	private String name; // 定义name属性

	public MyThread( String name ) {

		this.name = name;
	}

	public void run() {// 覆写run()方法

		for ( int i = 0; i < 50; i++ ) {// 表示循环10次

			System.out.println( "Thread运行：" + name + "，i = " + i );
		}
	}
}
