package bj.Java1200.col01.ch05_面向对象技术应用.ch05_7_接口与内部类._118_适配器模式的简单应用;


public class Test {

	public static void main( String[] args ) {

		System.out.println( "自定义普通的汽车：" );
		Car car = new Car();
		car.setName( "Adui" );
		car.setSpeed( 60 );
		System.out.println( car );
		System.out.println( "自定义GPS汽车：" );
		GPSCar gpsCar = new GPSCar();
		gpsCar.setName( "Audi" );
		gpsCar.setSpeed( 60 );
		System.out.println( gpsCar );
	}
}
