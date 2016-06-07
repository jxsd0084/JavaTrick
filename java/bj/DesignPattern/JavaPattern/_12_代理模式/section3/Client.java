package bj.DesignPattern.JavaPattern._12_代理模式.section3;

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

		Subject proxy = new RealSubject();

		proxy.request();

	}

}
