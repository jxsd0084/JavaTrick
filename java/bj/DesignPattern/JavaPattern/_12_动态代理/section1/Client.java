package bj.DesignPattern.JavaPattern._12_动态代理.section1;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		DynamicProxy proxy = new DynamicProxy( new RealSubject() );

		String[]     str   = { "1111" };

		proxy.exec( "doSomething", str );

	}

}
