package bj.DesignPattern.JavaAndPattern.KEYGEN.VER5;

public class Client {

	private static KeyGenerator keygen;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		keygen = KeyGenerator.getInstance( "PO_NUMBER" );

		for ( int i = 0; i < 25; i++ ) {
			System.out.println( "key(" + ( i + 1 )
			                    + ")= " + keygen.getNextKey() );
		}
	}

}
