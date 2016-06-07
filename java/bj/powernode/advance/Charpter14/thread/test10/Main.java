package bj.powernode.advance.Charpter14.thread.test10;

public class Main {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建Ticket类的对象
		Ticket ticket = new Ticket();

		// 创建InitThread类的对象
		InitThread it = new InitThread( ticket );

		try {
			// join()--等待该线程终止
			it.join();
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}

		// 创建卖票线程对象123
		new SellTicketThread( ticket, "买票线程1" );
		new SellTicketThread( ticket, "买票线程2" );
		new SellTicketThread( ticket, "买票线程3" );
	}

}
