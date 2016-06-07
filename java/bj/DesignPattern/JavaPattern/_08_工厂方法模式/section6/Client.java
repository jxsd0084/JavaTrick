package bj.DesignPattern.JavaPattern._08_工厂方法模式.section6;

public class Client {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		Factory.createProduct( "Product1" );
		Factory.createProduct( "Product2" );
		Factory.createProduct( "Product1" );
		Factory.createProduct( "Product1" );
		Factory.createProduct( "Product2" );

		System.out.println( Factory.getMap().keySet().size() );

	}

}
