package bj.powernode.advance.Charpter14.thread.test10;

// 创建线程类去继承Thread,此线程类用来初始化车票
public class InitThread extends Thread {

	// 车票类型的属性
	private Ticket ticket;

	// 有参构造方法,参数:Ticket ticket
	public InitThread( Ticket ticket ) {

		this.ticket = ticket;
		this.start();
	}

	// 重写Thread类 的run方法
	public void run() {
		// 在run方法中去调用Ticket类中的 initialize方法
		ticket.initialize();
	}
}
