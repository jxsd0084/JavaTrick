package bj.mldn.javase01.no42.pcdemo02;

public class Consumer implements Runnable {

	private Info info = null;

	public Consumer( Info info ) {

		this.info = info;
	}

	public void run() {

		for ( int x = 0; x < 100; x++ ) {

			this.info.get();
		}
	}

}
