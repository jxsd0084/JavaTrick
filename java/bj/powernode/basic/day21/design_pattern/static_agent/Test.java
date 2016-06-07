package bj.powernode.basic.day21.design_pattern.static_agent;

public class Test {

	/**
	 * 测试代理模式
	 */
	public static void main( String[] args ) {

		CommonInterface cif = new Agent( new Target() );

		boolean result = cif.method();

		System.out.println( result ); //false

	}

}
