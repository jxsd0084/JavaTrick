package bj.powernode.advance.Charpter14.thread.test8;

// 李飞取钱线程继承Thread
public class LiFeiThread extends Thread {

	// 银行账户属性Account
	private Account account;

	// 有参构造方法(String name,Account account)
	public LiFeiThread( String name, Account account ) {

		super( name );
		this.account = account;
		this.start();
	}

	// 重写父类Thread的run方法
	public void run() {

		try {

			//调用account类的getMoney1方法取款并赋值给int money
			int money = account.getMoney1( 500 );

			//输出取款成功信息
			System.out.println( "李飞线程取款成功!" + money );

		} catch ( AccountException e ) {
			e.printStackTrace();
		}
	}

}
