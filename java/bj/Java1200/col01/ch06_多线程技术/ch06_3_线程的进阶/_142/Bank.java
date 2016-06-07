package bj.Java1200.col01.ch06_多线程技术.ch06_3_线程的进阶._142;

public class Bank {

	private static ThreadLocal< Integer > account = new ThreadLocal< Integer >() {

		@Override
		protected Integer initialValue() {

			return 100;
		}

	};

	public void deposit( int money ) {

		account.set( account.get() + money );
	}

	public int getAccount() {

		return account.get();
	}
}
