package bj.DesignPattern.JavaAndPattern.immutable.PIG;

public class TheMonk {

	private static Pig bajie;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		System.out.println( "==============starting==============" );
		bajie = new Bajie();

		bajie.speak();

		bajie.walk();
		System.out.println( "==============finishing==============" );

		System.out.println( "==============starting==============" );
		bajie = new Bajie( "Hello" );

		bajie.speak();

		bajie.walk();
		System.out.println( "==============finishing==============" );

	}

}
