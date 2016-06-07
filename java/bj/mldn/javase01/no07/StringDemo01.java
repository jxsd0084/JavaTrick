package bj.mldn.javase01.no07;

public class StringDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str1 = "hello";                // 使用直接赋值的方式完成

		String str2 = new String( "MLDN" );   // 通过构造方法完成

		System.out.println( str1 + str2 );    // 进行字符串的连接操作

	}

}
