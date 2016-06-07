package bj.DesignPattern.sxt_pattern.decorator;

public class Client {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Car car = new Car();
		car.move();

		System.out.println( "增加新的功能，飞行----------" );
		FlyCar flycar = new FlyCar( car );
		flycar.move();

		System.out.println( "增加新的功能，水里游---------" );
		WaterCar waterCar = new WaterCar( car );
		waterCar.move();

		System.out.println( "增加两个新的功能，飞行，水里游-------" );
		WaterCar waterCar2 = new WaterCar( new FlyCar( car ) );
		waterCar2.move();

		// Reader r = new BufferedReader(new InputStreamReader(new
		// FileInputStream(new File("d:/a.txt"))));

	}

}
