package bj.powernode.basic.day18.bank02;

import java.io.Serializable;


// 多线程取款

/*

	线程同步锁 synchronized
	
	synchronized将包含的代码块变成了单线程.所以synchronized包含的代码尽量少一些.

*/
public class Bank_Mgt_Sys_02 {

	// 主方法 --> 主线程
	public static void main( String[] args ) {

		WithdrawRunnable r = new WithdrawRunnable();

		Thread t1 = new Thread( r );

		Thread t2 = new Thread( r );

		t1.start();
		t2.start();

	}

}


// 自定义一个线程类
class WithdrawRunnable implements Runnable {

	// 公共账户
	Account act01 = new Account( 10000.0 );

	public void run() {

		// 2.取款
		act01.withdraw( 3000.0 ); //取款5000.0

		// 3.查看余额
		act01.queryBalance();
	}

}


/*

	抽象这个系统中的实体类:账户

	在应用程序中,实体类(javabean,entity,po,pojo)有可能被序列化到文件中.或者网络中.

*/
class Account implements Serializable {

	// 序列化版本号
	public static final long serialVersionUID = 12345678910254L;

	// 属性
	private double balance; // 余额


	// 构造方法
	public Account() {

		super();
	}

	public Account( double balance ) {

		this.balance = balance;
	}


	// setter and getter
	public void setBalance( double balance ) {

		this.balance = balance;
	}

	public double getBalance() {

		return balance;
	}


	// 查询余额
	public void queryBalance() {

		System.out.println( "当前余额:" + this.getBalance() );
	}
	
	
	/*

	// 取款方法(从账户中减去withdrawMoney)
	public void withdraw(double withdrawMoney){
		
		// 线程同步锁
		synchronized(this){ // 锁的是线程的公共数据 Account
			
			// 1.取款前账户余额
			double before = this.getBalance();      // 10000.0
			
			// 2.取款之后的余额
			double after = before-withdrawMoney;    // 7000.0
			
			// 模拟延迟
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			// 3.修改账户余额
			this.setBalance(after);                 //7000.0  7000.0
		}
	}

	*/


	// 取款方法(从账户中减去withdrawMoney)
	public synchronized void withdraw( double withdrawMoney ) {


		// 1.取款前账户余额
		double before = this.getBalance();      // 10000.0

		// 2.取款之后的余额
		double after = before - withdrawMoney;  // 7000.0

		// 模拟延迟
		try {
			Thread.sleep( 1000 );
		} catch ( Exception e ) {
			e.printStackTrace();
		}


		// 3.修改账户余额
		this.setBalance( after );               // 7000.0  7000.0

	}

}
