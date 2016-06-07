package bj.DesignPattern.JavaAndPattern.KEYGEN.VER1;

public class Client {

	private static KeyGenerator keygen;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		keygen = KeyGenerator.getInstance();

		System.out.println( "key = " + keygen.getNextKey() );
		System.out.println( "key = " + keygen.getNextKey() );
		System.out.println( "key = " + keygen.getNextKey() );
	}

}
