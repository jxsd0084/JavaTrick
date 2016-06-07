package bj.powernode.basic.day18;

import java.io.Serializable;

public class Bank_Mgt_Sys {

	// 主方法 --> 主线程
	public static void main( String[] args ) {

		// 1.开户
		Account act01 = new Account( 10000.0 );


		// 2.取款
		act01.withdraw( 5000.0 );   // 取款5000.0


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


	// 取款方法(从账户中减去withdrawMoney)
	public void withdraw( double withdrawMoney ) {

		// 1.取款前账户余额
		double before = this.getBalance();

		// 2.取款之后的余额
		double after = before - withdrawMoney;

		// 3.修改账户余额
		this.setBalance( after );

	}

}
