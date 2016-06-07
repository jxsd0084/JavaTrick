package bj.powernode.basic.day17.线程第一种实现方式;

/*

	启动Thread01线程.

*/
public class TestThread01 {

	// 主方法:主线程.
	public static void main( String[] args ) {

		// 启动其他线程,开启其他分支.
		Thread01 t1 = new Thread01();
		t1.start();  //启动线程t1  (t1线程如果抢到CPU的时间片之后,就会去执行run方法.)




		Thread01 t2 = new Thread01();
		t2.start();



		// ???? start方法调用,run方法马上执行!!! 错误的.
		// run 方法结束,代表线程结束.

	}

}
