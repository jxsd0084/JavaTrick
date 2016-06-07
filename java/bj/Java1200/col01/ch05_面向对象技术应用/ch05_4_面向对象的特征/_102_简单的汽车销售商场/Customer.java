package bj.Java1200.col01.ch05_面向对象技术应用.ch05_4_面向对象的特征._102_简单的汽车销售商场;

public class Customer {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( "顾客要购买BMW:" );

		Car bmw = CarFactory.getCar( "BMW" );
		System.out.println( "提取汽车：" + bmw.getInfo() );
		System.out.println( "顾客要购买Benz:" );

		Car benz = CarFactory.getCar( "Benz" );
		System.out.println( "提取汽车：" + benz.getInfo() );

	}

}
