package bj.DesignPattern.JavaPattern._36_观察者模式和中介者模式.section1;

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

		Product p = new Product( new ProductManager(), "abc" );

		System.out.println( p.getName() );

	}

}
