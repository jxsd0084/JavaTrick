package bj.mldn.javase01.no42.syndemo;

class FanBo {

	public synchronized void say( ZhangYang zy ) {

		System.out.println( "把钱给我，放了你弟弟。" );
		zy.give();
	}

	public synchronized void give() {

		System.out.println( "得到了钱，同时被警察抓了。" );
	}
}

class ZhangYang {

	public synchronized void say( FanBo fb ) {

		System.out.println( "把弟弟放了，我给你钱。" );
		fb.give();
	}

	public synchronized void give() {

		System.out.println( "弟弟救回来，同时报案了。" );
	}
}

public class DeadLockDemo implements Runnable {

	private FanBo     fb = new FanBo();
	private ZhangYang zy = new ZhangYang();

	public DeadLockDemo() {

		new Thread( this ).start();
		zy.say( fb );
	}

	public void run() {

		fb.say( zy );
	}

	public static void main( String[] args ) {

		new DeadLockDemo();
	}

}
