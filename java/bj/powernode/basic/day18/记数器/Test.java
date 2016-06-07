package bj.powernode.basic.day18.记数器;

public class Test {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		CounterRunnable r  = new CounterRunnable();
		Thread          t1 = new Thread( r );
		Thread          t2 = new Thread( r );

		t1.start();
		t2.start();

	}
}


class CounterRunnable implements Runnable {

	Counter c = new Counter( 0 );

	public void run() {

		c.count();
	}
}


// 计数器(抽象计数器这个实体类)
class Counter {

	// 属性(量)
	private long count;

	// 构造
	public Counter() {

	}

	public Counter( long count ) {

		this.count = count;
	}


	// setter and getter
	public void setCount( long count ) {

		this.count = count;
	}

	public long getCount() {

		return count;
	}

	// 计数+1
	public void count() {

		synchronized ( this ) {

			long before = this.getCount();

			long after = before + 1;

			System.out.println( "您是第" + after + "个访问者." );

			try {

				Thread.sleep( 1000 );
			} catch ( Exception e ) {
			}

			this.setCount( after );
		}


	}


}
