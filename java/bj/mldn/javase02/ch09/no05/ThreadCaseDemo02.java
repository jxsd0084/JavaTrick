package bj.mldn.javase02.ch09.no05;

class Info2 {    // 定义信息类

	private String name    = "李兴华";     // 定义name属性
	private String content = "JAVA讲师";   // 定义content属性

	public synchronized void set( String name, String content ) {

		this.setName( name );             // 设置名称
		try {
			Thread.sleep( 300 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		this.setContent( content );       // 设置内容
	}

	public synchronized void get() {

		try {
			Thread.sleep( 300 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		System.out.println( this.getName() + " --> " +
		                    this.getContent() );
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

class Producer2 implements Runnable {    // 通过Runnable实现多线程

	private Info2 info = null;           // 保存Info引用

	public Producer2( Info2 info ) {

		this.info = info;
	}

	public void run() {

		boolean flag = false;                                  // 定义标记位
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

class Consumer2 implements Runnable {

	private Info2 info = null;

	public Consumer2( Info2 info ) {

		this.info = info;
	}

	public void run() {

		for ( int i = 0; i < 50; i++ ) {
			this.info.get();
		}
	}
}

public class ThreadCaseDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info2     info = new Info2();              // 实例化Info对象
		Producer2 pro  = new Producer2( info );    // 生产者
		Consumer2 con  = new Consumer2( info );    // 消费者
		new Thread( pro ).start();
		new Thread( con ).start();
	}
}
