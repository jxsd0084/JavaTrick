package bj.mldn.javase01.no42.pcdemo03;

public class Info {

	private String  title   = "李兴华";
	// private String title = "MLDN";
	private String  content = "Java讲师";
	// private String content = "www.mldnjava.cn";
	private boolean flag    = false; // 默认是false

	/*
	 * 1、flag = true，表示可以生产，但是不能取走
	 * 
	 * 2、flag = false，表示可以取走，但是不能生产
	 */
	public synchronized void set( String title, String content ) {

		if ( flag == false ) {// 已经生产过了，需要等待

			try {
				super.wait(); // 等待

			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		}
		this.setTitle( title );

		try {
			Thread.sleep( 300 ); // 休眠0.3秒

		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}

		this.setContent( content );
		this.flag = false;// 表示不能生产了
		super.notify(); // 唤醒其他等待的线程
	}

	public synchronized void get() {

		if ( flag == true ) {// 表示不能取
			try {
				super.wait(); // 等待

			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		}

		System.out.println( this.title + " --> " + this.content );
		this.flag = true;// 表示不能取走了
		super.notify(); // 唤醒
	}

	public String getTitle() {

		return title;
	}

	public void setTitle( String title ) {

		this.title = title;
	}

	public String getContent() {

		return content;
	}

	public void setContent( String content ) {

		this.content = content;
	}

}
