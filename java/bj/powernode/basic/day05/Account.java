package bj.powernode.basic.day05;


//  属性私有化,提供公开的访问方法
public class Account {

	//  属性
	private String actNo;   //  账号
	private double balance; //  余额


	//  构造方法

	//  缺省构造器
	public Account() {

	}  // public表示完全公开,在程序的任何地方都可以使用该构造方法


	//  有参数的构造方法'
	public Account( String _actNo, double _balance ) {

		actNo = _actNo;
		balance = _balance;
	}

	//  方法
	public void setActNo( String _actNo ) {

		actNo = _actNo;
	}

	public String getActNo() {

		return actNo;
	}

	public void setBalance( double _balance ) {

		balance = _balance;
	}

	public double getBalance() {

		return balance;
	}

}
