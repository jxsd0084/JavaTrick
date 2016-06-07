package bj.mldn.javase02.ch11.no01;

public class StringBufferDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		StringBuffer buf = new StringBuffer();    // 声明StringBuffer对象
		buf.append( "World!!" );                  // 添加内容
		buf.insert( 0, "Hello " );                // 在第一个内容之前添加内容
		String str = buf.reverse().toString();    // 将内容反转后变为String类型
		System.out.println( str );                 // 将内容输出
	}
}
