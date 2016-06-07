package threads.JavaThreadDesign.ch5;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static class Soldier implements Runnable {

		private       String        soldier;
		private final CyclicBarrier cyclic;

		Soldier( CyclicBarrier cyclic, String soldierName ) {

			this.cyclic = cyclic;
			this.soldier = soldierName;
		}

		public void run() {

			try {

				//等待所有士兵到齐
				cyclic.await();

				doWork();

				//等待所有士兵完成工作
				cyclic.await();

			} catch ( InterruptedException e ) {
				e.printStackTrace();

			} catch ( BrokenBarrierException e ) {
				e.printStackTrace();

			}

		}

		void doWork() {

			try {

				Thread.sleep( Math.abs( new Random().nextInt() % 10000 ) );

			} catch ( InterruptedException e ) {
				e.printStackTrace();

			}

			System.out.println( soldier + ":任务完成" );

		}

	}

	public static class BarrierRun implements Runnable {

		boolean flag;
		int     N;

		public BarrierRun( boolean flag, int N ) {

			this.flag = flag;
			this.N = N;
		}

		public void run() {

			if ( flag ) {
				System.out.println( "司令:[士兵" + N + "个，任务完成！]" );

			} else {
				System.out.println( "司令:[士兵" + N + "个，集合完毕！]" );
				flag = true;
			}

		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main( String args[] ) throws InterruptedException {

		final int N          = 10;
		Thread[]  allSoldier = new Thread[ N ];
		boolean   flag       = false;

		CyclicBarrier cyclic = new CyclicBarrier( N, new BarrierRun( flag, N ) );

		//设置屏障点，主要是为了执行这个方法
		System.out.println( "集合队伍！" );

		for ( int i = 0; i < N; ++i ) {

			System.out.println( "士兵 " + i + " 报道！" );

			allSoldier[ i ] = new Thread( new Soldier( cyclic, "士兵 " + i ) );
			allSoldier[ i ].start();

			if ( i == 5 ) {

				allSoldier[ 0 ].interrupt();
			}
		}
	}
}

/*

CyclicBarrier介绍

URL:    http://www.cnblogs.com/whgw/archive/2011/09/29/2195669.html


一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。

在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，此时 CyclicBarrier 很有用。

因为该 barrier 在释放等待线程后可以重用，所以称它为循环 的 barrier。


应用场景:

在某种需求中，

比如一个大型的任务，常常需要分配好多子任务去执行，只有当所有子任务都执行完成时候，才能执行主任务，

这时候，就可以选择CyclicBarrier了。

*/