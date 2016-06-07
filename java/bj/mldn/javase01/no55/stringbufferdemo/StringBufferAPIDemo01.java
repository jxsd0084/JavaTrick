package bj.mldn.javase01.no55.stringbufferdemo;

public class StringBufferAPIDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		StringBuffer buf = new StringBuffer();

		buf.append( "hello" );
		buf.append( " " ).append( "world" ).append( "!!!" );

		buf.insert( 1, "LXH" );
		buf.insert( 0, "MLDN" );

		System.out.println( buf );

	}

}
