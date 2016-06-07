package bj.Java1200.col01.ch06_多线程技术.ch06_2_线程的同步._137;

public class Bank {

	// 使用ThreadLocal类来管理共享变量account
	private static ThreadLocal< Integer > account = new ThreadLocal< Integer >() {

		@Override
		protected Integer initialValue() {

			return 100;// 重写initialValue()方法，将account的初始值设为100
		}
	};

	public void deposit( int money ) {

		account.set( account.get() + money );// 利用account的get()、set()方法实现存钱
	}

	public int getAccount() {// 获得账户余额
		return account.get();
	}
}
