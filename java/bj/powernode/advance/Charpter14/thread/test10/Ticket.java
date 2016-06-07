package bj.powernode.advance.Charpter14.thread.test10;

public class Ticket {

	// 准备String类型的数组arr并进行初始化
	private String[] arr = new String[ 100 ];

	// 初始化数组下标并赋值
	private int index = 99;

	/**
	 * 初始化化车票的方法
	 */
	public void initialize() {

		// 循环遍历数组
		for ( int i = 0; i < arr.length; i++ ) {

			// 将数组遍历出来的值赋给String类型的变量s
			String s = "第" + i + "号车票";

			// String类型的变量s赋值给arr数组
			arr[ i ] = s;
		}
	}

	// 加了同步线程锁的卖票方法sellTicket
	public synchronized String sellTicket() {

		// 判断一下,如果下标大于等于0时
		if ( index >= 0 ) {

			// 将数组元素赋给String类型的变量s
			String s = arr[ index ];
			try {

				// 此时让线程睡上10毫秒
				Thread.sleep( 10 );

				// InterruptedException--当线程在活动之前或活动期间处于正在等待、休眠或占用状态且该线程被中断时，抛出该异常
				// 有时候，一种方法可能希望测试当前线程是否已被中断，如果已被中断，则立即抛出此异常
			} catch ( InterruptedException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 将下标所指向的数组元素清空
			arr[ index ] = null;

			// 下标向下移动
			index--;

			// 将从数组中取到的String类型变量s作为返回值返回
			return s;
		} else {

			// 此处还准备了一个自定义异常,抛出自定义异常
			throw new TicketException( "车票已经售完" );
		}
	}
}
