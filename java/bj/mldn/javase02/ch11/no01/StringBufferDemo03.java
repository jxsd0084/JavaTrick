package bj.mldn.javase02.ch11.no01;

public class StringBufferDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		StringBuffer buf = new StringBuffer();    // 声明StringBuffer对象
		buf.append( "World!!" );                  // 添加内容
		buf.insert( 0, "Hello " );                // 在第一个内容之前添加内容
		System.out.println( buf );
		buf.insert( buf.length(), "MLDN~" );      // 在最后添加内容
		System.out.println( buf );
	}
}
