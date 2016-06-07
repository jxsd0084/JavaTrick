package bj.mldn.javase01.no42.pcdemo02;

public class Producer implements Runnable {

	private Info info = null;

	public Producer( Info info ) {
		this.info = info;
	}

	public void run() {

		for ( int x = 0; x < 100; x++ ) { // 不断的生产

			if ( x % 2 == 1 ) {// 是奇数
				this.info.set( "MLDN", "www.mldnjava.cn" );

			} else {
				this.info.set( "李兴华", "Java讲师" );
			}
		}
	}
}
