package bj.mldn.javase01.no55.stringbufferdemo;

public class StringBufferAPIDemo02 {

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

		System.out.println( buf.delete( 0, 9 ) );    // 将0~9的内容删除掉

	}

}
