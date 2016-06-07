package bj.DesignPattern.JavaAndPattern.flyweight.SIMPLE;

public class ClientSingleton {

	private static FlyweightFactorySingleton factory;

	/**
	 * 测试
 	 * @param args
	 */
	static public void main( String[] args ) {
		factory = FlyweightFactorySingleton.getInstance();

		Flyweight fly = factory.factory( new Character( 'a' ) );
		fly.operation( "First Call" );

		fly = factory.factory( new Character( 'b' ) );
		fly.operation( "Second Call" );

		fly = factory.factory( new Character( 'a' ) );
		fly.operation( "Third Call" );

		// intrinsic Flyweight
		factory.checkFlyweight();
	}

}
