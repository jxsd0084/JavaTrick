package threads.JavaThreadCookBook.ch03_Thread安全.demo1_线程不安全;

public class ThreadA extends Thread {

	private Count count;

	public ThreadA( Count count ) {

		this.count = count;
	}

	public void run() {

		count.add();
	}

}
