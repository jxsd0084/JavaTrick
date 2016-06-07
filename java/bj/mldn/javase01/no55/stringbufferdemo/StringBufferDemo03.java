package bj.mldn.javase01.no55.stringbufferdemo;

public class StringBufferDemo03 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		StringBuffer buf = new StringBuffer();

		fun( buf ); // 传递引用

		for ( int i = 0; i < 1000; i++ ) {

			buf.append( i );    // 修改1000次内容
		}

		System.out.println( buf );
	}

	public static void fun( StringBuffer b ) {

		b.append( "hello world!!!" ).append( "\n" );
	}

}
