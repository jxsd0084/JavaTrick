package bj.DesignPattern.sxt_pattern.factory.factorymethod;


public class Client {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		Car c1 = new AudiFactory().createCar();
		Car c2 = new BydFactory().createCar();

		c1.run();
		c2.run();
	}

}
