package threads.JavaThreadCookBook.ch03_Thread安全.demo4_死锁;

public class ThreadB extends Thread {

	private Count count;

	public ThreadB( Count count ) {

		this.count = count;
	}

	public void run() {

		count.lockMethod();
	}
}
