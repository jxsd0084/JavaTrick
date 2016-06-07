package bj.mldn.javase01.no01;

public class SimpleDemo {    // 声明一个类，类名称的命名规范：所有单词的首字母大写

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {    // 主方法


		int max = Integer.MAX_VALUE;    // 求出整型的最大值
		int min = Integer.MIN_VALUE;    // 求出整型的最小值



		System.out.println( "int的最大值：" + max );             // 2147483647
		System.out.println( "int的最大值 + 1：" + ( max + 1 ) ); // -2147483648

		System.out.println( "int的最小值：" + min );             // -2147483648
		System.out.println( "int的最小值 - 1：" + ( min - 1 ) ); // 2147483647

		int x = 10;    // 10表示一个常量，在java中默认是int型

	}

}
