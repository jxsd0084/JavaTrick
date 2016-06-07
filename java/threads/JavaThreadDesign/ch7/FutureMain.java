package threads.JavaThreadDesign.ch7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureMain {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String[] args ) throws InterruptedException, ExecutionException {

		// 构造FutureTask
		FutureTask< String > future = new FutureTask< String >( new RealData( "a" ) );

		ExecutorService executor = Executors.newFixedThreadPool( 1 );

		// 执行FutureTask，相当于上例中的 client.request("a") 发送请求
		// 在这里开启线程进行RealData的call()执行
		executor.submit( future );

		System.out.println( "�������" );

		try {

			// 这里依然可以做额外的数据操作，这里使用sleep代替其他业务逻辑的处理
			Thread.sleep( 2000 );

		} catch ( InterruptedException e ) {

		}

		// 相当于data.getResult ()，取得call()方法的返回值
		// 如果此时call()方法没有执行完成，则依然会等待

		System.out.println( "���� = " + future.get() );

	}

}

/*

Java多线程编程中Future模式的详解

URL:    http://www.2cto.com/kf/201411/351903.html


Future模式有点类似于商品订单。

在网上购物时，提交订单后，在收货的这段时间里无需一直在家里等候，可以先干别的事情。

类推到程序设计中时，当提交请求时，期望得到答复时，如果这个答复可能很慢。

传统的时一直等待到这个答复收到时再去做别的事情，但如果利用Future设计模式就无需等待答复的到来，

在等待答复的过程中可以干其他事情。

*/
