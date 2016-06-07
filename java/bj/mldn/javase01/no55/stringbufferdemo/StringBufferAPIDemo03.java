package bj.mldn.javase01.no55.stringbufferdemo;

public class StringBufferAPIDemo03 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		StringBuffer buf = new StringBuffer();

		buf.append( "hello" );
		buf.append( " " ).append( "world" ).append( "!!!" );

		System.out.println( buf.reverse() );    // 将内容反转

	}

}
