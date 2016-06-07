package bj.DesignPattern.JavaAndPattern.multilingual.DICE;

public class Client {

	private static Die die1;
	private static Die die2;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		die1 = Die.getInstance( 1 );
		die2 = Die.getInstance( 2 );

		die1.dice();
		die2.dice();
	}

}
