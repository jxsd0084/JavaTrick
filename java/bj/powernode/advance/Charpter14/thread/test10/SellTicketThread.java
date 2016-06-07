package bj.powernode.advance.Charpter14.thread.test10;

// 创建卖票类线程继承Thread
public class SellTicketThread extends Thread {

	// Ticket类属性
	private Ticket ticket;

	// 有参构造方法,参数Ticket ticket, String name,在构造方法中调用start方法,对象创建时自动启动线程
	public SellTicketThread( Ticket ticket, String name ) {

		super( name );
		this.ticket = ticket;
		this.start();
	}

	// 重写父类的run方法
	public void run() {
		// for循环从0到39
		for ( int i = 0; i < 40; i++ ) {

			// 调用Ticket类中的sellTicket方法,此方法的返回值用String类型的s接收
			String s = ticket.sellTicket();
			// 输出信息,线程名
			System.out.println( this.getName() + "买票成功:" + s );
		}
	}
}
