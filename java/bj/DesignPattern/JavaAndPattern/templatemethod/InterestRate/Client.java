package bj.DesignPattern.JavaAndPattern.templatemethod.InterestRate;

public class Client {

	private static Account acct = null;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		acct = new MoneyMarketAccount();
		System.out.println( "Interest earned from Money Market account = " + acct.calculateInterest() );

		acct = new CDAccount();
		System.out.println( "Interest earned from CD account = " + acct.calculateInterest() );
	}

}
