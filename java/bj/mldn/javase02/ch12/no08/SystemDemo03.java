package bj.mldn.javase02.ch12.no08;

public class SystemDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str = "hello";        // 声明一个非数字的字符串
		try {
			System.out.println( Integer.parseInt( str ) );    // 转型
		} catch ( Exception e ) {
			System.out.println( e );
		}
	}
}
