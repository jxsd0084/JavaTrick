package bj.Java1200.col01.ch02_Java基础应用.ch02_2_运算符._23_加密可以这样简单;

import java.util.Scanner;

/**
 * 023 加密可以这样简单
 */
public class Example {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Scanner scan = new Scanner( System.in );

		System.out.println( "请输入一个英文字符串或解密字符串" );
		String password = scan.nextLine();              // 获取用户输入

		char[] array = password.toCharArray();       // 获取字符数组
		for ( int i = 0; i < array.length; i++ ) {      // 遍历字符数组
			array[ i ] = (char) ( array[ i ] ^ 20000 ); // 对每个数组元素进行异或运算
		}

		System.out.println( "加密或解密结果如下：" );
		System.err.println( new String( array ) );// 输出密钥

	}

}
