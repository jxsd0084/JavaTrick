package bj.powernode.basic.day05;


public class TestAccount {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		//  1.创建对象
		Account act1 = new Account();                           //  调用无参数构造方法

		Account act2 = new Account( "actno-001", 50000.0 );     // 调用有参数的构造方法

		System.out.println( act1.getActNo() );  // null
		System.out.println( act1.getBalance() ); // 0.0


		//  2.修改act1的账号.
		act1.setActNo( "actno-003" );

		//  3.修改act1的余额
		act1.setBalance( 1000.0 );

		//  4.读取act1的账号
		System.out.println( act1.getActNo() );      // actno-003

		//  5.读取act1的账户的余额
		System.out.println( act1.getBalance() );    // 1000.0


		//  6.读取act2的账号
		System.out.println( act2.getActNo() );

		//  7.读取act2的余额
		System.out.println( act2.getBalance() );


	}
}
