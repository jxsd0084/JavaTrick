package bj.DesignPattern.sxt_pattern.state;

public class Client {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		HomeContext ctx = new HomeContext();

		ctx.setState( new FreeState() );
		ctx.setState( new BookedState() );

	}

}
