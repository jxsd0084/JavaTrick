package bj.mldn.javase01.no42.pcdemo01;

public class Consumer implements Runnable {

	private Info info = null;

	public Consumer( Info info ) {

		this.info = info;
	}

	public void run() {

		for ( int x = 0; x < 100; x++ ) {

			try {

				Thread.sleep( 300 ); // 休眠0.3秒

			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}

			System.out.println( this.info.getTitle() + " -> " +
			                    this.info.getContent() ); // 取内容
		}

	}

}
