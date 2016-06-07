package bj.powernode.advance.Charpter14.thread.test6;

//测试类
public class Main {

	// 主方法测试
	public static void main( String[] args ) {
		// 创建线程对象
		MyThread  t1 = new MyThread( "线程1" );
		MyThread1 t2 = new MyThread1( "线程2" );
		// 设置线程优先级
		// t1.setPriority(Thread.MAX_PRIORITY);
		// t2.setPriority(Thread.MIN_PRIORITY);
		// 取到线程
		t1.start();
		t2.start();

	}

}
