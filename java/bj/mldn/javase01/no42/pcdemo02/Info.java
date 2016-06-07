package bj.mldn.javase01.no42.pcdemo02;

public class Info {

	private String title   = "李兴华";
	// private String title = "MLDN";
	private String content = "Java讲师";

	// private String content = "www.mldnjava.cn";
	public synchronized void set( String title, String content ) {

		this.setTitle( title );

		try {

			Thread.sleep( 300 ); // 休眠0.3秒

		} catch ( InterruptedException e ) {

			e.printStackTrace();
		}

		this.setContent( content );
	}

	public synchronized void get() {
		System.out.println( this.title + " --> " + this.content );
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
