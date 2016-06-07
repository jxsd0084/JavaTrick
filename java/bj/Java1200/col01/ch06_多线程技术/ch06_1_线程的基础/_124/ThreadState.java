package bj.Java1200.col01.ch06_多线程技术.ch06_1_线程的基础._124;

/**
 * Created by Administrator on 2016/6/1.
 */
public class ThreadState implements Runnable {

	public synchronized void waitForASecond() throws InterruptedException {

		wait( 500 ); // 使当前线程等待0.5秒或其他线程调用notify()或notifyAll()方法
	}

	public synchronized void waitForYears() throws InterruptedException {

		wait(); // 使当前线程永久等待，直到其他线程调用notify()或notifyAll()方法
	}

	public synchronized void notifyNow() throws InterruptedException {

		notify(); // 唤醒由调用wait()方法进入等待状态的线程
	}

	@Override
	public void run() {

		try {
			waitForASecond(); // 在新线程中运行waitForASecond()方法
			waitForYears(); // 在新线程中运行waitForYears()方法
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
	}

}
