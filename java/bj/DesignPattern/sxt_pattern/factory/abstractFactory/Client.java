package bj.DesignPattern.sxt_pattern.factory.abstractFactory;

public class Client {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		CarFactory factory = new LuxuryCarFactory();

		Engine     e       = factory.createEngine();

		e.run();

		e.start();

	}

}
