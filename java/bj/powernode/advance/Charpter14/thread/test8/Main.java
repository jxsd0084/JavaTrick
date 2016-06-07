package bj.powernode.advance.Charpter14.thread.test8;

public class Main {

	// 主方法测试
	public static void main( String[] args ) {

		// 创建账户对象
		Account account = new Account();

		// 创建取款线程对象
		LiFeiThread  lf = new LiFeiThread( "李飞", account );
		XiaoLiThread xl = new XiaoLiThread( "小丽", account );

		// 取到取款线程对象
		lf.start();
		xl.start();
	}

}
