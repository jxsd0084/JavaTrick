package bj.DesignPattern.sxt_pattern.strategy;

public class Client {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Strategy s1  = new OldCustomerManyStrategy();
		Context  ctx = new Context( s1 );

		ctx.pringPrice( 998 );
	}

}
