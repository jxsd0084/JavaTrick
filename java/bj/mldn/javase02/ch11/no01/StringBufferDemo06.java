package bj.mldn.javase02.ch11.no01;

public class StringBufferDemo06 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		StringBuffer buf = new StringBuffer();              // 声明StringBuffer对象
		buf.append( "Hello " ).append( "World!!" );         // 向StringBuffer添加内容
		buf.replace( 6, 11, "LiXingHua" );                  // 将world的内容替换
		String str = buf.substring( 6, 15 );                // 截取指定范围的内容
		System.out.println( "内容替换之后的结果：" + str );    // 输出内容
	}

}
