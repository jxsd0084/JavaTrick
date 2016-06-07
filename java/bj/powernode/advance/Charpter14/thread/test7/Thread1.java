package bj.powernode.advance.Charpter14.thread.test7;

/**
 * 关键字join()方法:等待该线程终止。
 *
 * @author Administrator
 */

//创建类Thread1继承Thread
public class Thread1 extends Thread {

	// 静态String类型数组,并且类加载的时候进行初始化容量100
	private static String[] arr = new String[ 100 ];

	public Thread1() {

		this.start();
	}

	// 重写父类Thread的run方法
	public void run() {
		// for循环遍历arr数组,并且将循环得到的i值赋给arr数组
		for ( int i = 0; i < arr.length; i++ ) {
			arr[ i ] = "Hello" + i;
			// 输出arr数组
			System.out.println( "线程在初始化数组的内容:" + arr[ i ] );
		}
	}

	// 主方法
	public static void main( String[] args ) {
		// 创建线程对象并在构造方法中取到该线程
		Thread1 t1 = new Thread1();

		try {

			// 在主线程中调用了t1线程的join方法,则调用线程(也就是主线程)将阻塞
			// 直到被调用线程(也就是t1线程)运行结束为止,然后主线程才解除阻塞状态
			t1.join();
		} catch ( InterruptedException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//主线程for循环遍历arr数组
		for ( int i = 0; i < arr.length; i++ ) {
			//输出arr数组
			System.out.println( "主线程在输出数组的内容: arr[" + i + "]=" + arr[ i ] );
		}
	}
}
