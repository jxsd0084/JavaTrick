package bj.DesignPattern.sxt_pattern.builder;

public class Client {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		AirShipDirector director = new SxtAirshipDirector( new SxtAirShipBuilder() );

		AirShip ship = director.directAirShip();

		System.out.println( ship.getEngine().getName() );

		ship.launch();

	}

}
