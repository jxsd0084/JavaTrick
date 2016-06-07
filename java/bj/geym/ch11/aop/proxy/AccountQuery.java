package bj.geym.ch11.aop.proxy;

public class AccountQuery {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Account acc = AccountFactory.newAccount2();
		long    b   = System.currentTimeMillis();
		System.out.println( acc.query() );
		System.out.println( acc.query() );
		long e = System.currentTimeMillis();
		System.out.println( e - b );
	}

}
