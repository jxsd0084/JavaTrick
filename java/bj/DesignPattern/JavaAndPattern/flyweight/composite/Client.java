package bj.DesignPattern.JavaAndPattern.flyweight.composite;

public class Client {

	private static FlyweightFactory factory;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		factory = new FlyweightFactory();

		Flyweight fly;
/*        fly = factory.factory(new Character('a'));
		fly.operation();
		
		fly = factory.factory(new Character('b'));
		fly.operation();
		
		fly = factory.factory(new Character('a'));
		fly.operation();
*/
		fly = factory.factory( "abc" );
		fly.operation( "Composite Call" );

// intrinsic Flyweight
		factory.checkFlyweight();
	}

}
