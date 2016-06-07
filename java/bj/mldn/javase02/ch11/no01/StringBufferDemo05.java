package bj.mldn.javase02.ch11.no01;

public class StringBufferDemo05 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		StringBuffer buf = new StringBuffer();              // 声明StringBuffer对象
		buf.append( "Hello " ).append( "World!!" );         // 向StringBuffer添加内容
		buf.replace( 6, 11, "LiXingHua" );                  // 将world的内容替换
		System.out.println( "内容替换之后的结果：" + buf );    // 输出内容
	}
}
