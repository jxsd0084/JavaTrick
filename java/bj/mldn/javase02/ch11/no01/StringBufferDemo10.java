package bj.mldn.javase02.ch11.no01;

public class StringBufferDemo10 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		StringBuffer buf = new StringBuffer();
		buf.append( "LiXingHua" );
		for ( int i = 0; i < 100; i++ ) {
			buf.append( i );        // StringBuffer可以修改，性能高
		}
		System.out.println( buf );
	}
}
