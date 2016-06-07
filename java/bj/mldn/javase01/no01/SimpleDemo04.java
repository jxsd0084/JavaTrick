package bj.mldn.javase01.no01;

public class SimpleDemo04 {    // 声明一个类，类名称的命名规范：所有单词的首字母大写

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {    // 主方法

		String str = "hello ";    // 表示字符串

		int i = 10;

		System.out.println( str + ( i + 20 ) ); // hello 30

		System.out.println( 1L + 11 );          // 12

		int res = 11 + 11;
		System.out.println( res );              // 22

	}

}
