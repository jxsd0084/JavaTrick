package bj.mldn.javase02.ch09.no05;

class Info3 {    // 定义信息类

	private String  name    = "李兴华";     // 定义name属性
	private String  content = "JAVA讲师";   // 定义content属性
	private boolean flag    = false;       // 设置标志位

	public synchronized void set( String name, String content ) {

		if ( ! flag ) {
			try {
				super.wait();
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		}
		this.setName( name );          // 设置名称
		try {
			Thread.sleep( 300 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		this.setContent( content );    // 设置内容
		flag = false;                  // 改变标志位，表示可以取走
		super.notify();
	}

	public synchronized void get() {

		if ( flag ) {
			try {
				super.wait();
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep( 300 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		System.out.println( this.getName() + " --> " +
		                    this.getContent() );
		flag = true;                    // 改变标志位，表示可以生产
		super.notify();
	}

	public void setName( String name ) {

		this.name = name;
	}

	public void setContent( String content ) {

		this.content = content;
	}

	public String getName() {

		return this.name;
	}

	public String getContent() {

		return this.content;
	}
}

class Producer3 implements Runnable {    // 通过Runnable实现多线程

	private Info3 info = null;           // 保存Info引用

	public Producer3( Info3 info ) {

		this.info = info;
	}

	public void run() {

		boolean flag = false;                                 // 定义标记位
		for ( int i = 0; i < 50; i++ ) {
			if ( flag ) {
				this.info.set( "李兴华", "JAVA讲师" );          // 设置名称
				flag = false;
			} else {
				this.info.set( "mldn", "www.mldnjava.cn" );    // 设置名称
				flag = true;
			}
		}
	}
}

class Consumer3 implements Runnable {

	private Info3 info = null;

	public Consumer3( Info3 info ) {

		this.info = info;
	}

	public void run() {

		for ( int i = 0; i < 50; i++ ) {
			this.info.get();
		}
	}
}

public class ThreadCaseDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info3     info = new Info3();              // 实例化Info对象
		Producer3 pro  = new Producer3( info );    // 生产者
		Consumer3 con  = new Consumer3( info );    // 消费者
		new Thread( pro ).start();
		new Thread( con ).start();
	}
}
