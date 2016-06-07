package bj.mldn.javase01.no42.pcdemo01;

public class Producer implements Runnable {

	private Info info = null;

	public Producer( Info info ) {
		this.info = info;
	}

	public void run() {

		for ( int x = 0; x < 100; x++ ) { // 不断的生产

			if ( x % 2 == 1 ) {// 是奇数
				this.info.setTitle( "MLDN" );

				try {

					Thread.sleep( 300 ); // 休眠0.3秒

				} catch ( InterruptedException e ) {
					e.printStackTrace();
				}
				this.info.setContent( "www.mldnjava.cn" );

			} else {

				this.info.setTitle( "李兴华" );

				try {

					Thread.sleep( 300 ); // 休眠0.3秒

				} catch ( InterruptedException e ) {
					e.printStackTrace();
				}
				this.info.setContent( "Java讲师" );
			}

		}

	}

}
