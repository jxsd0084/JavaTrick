package bj.Java1200.col01.ch02_Java基础应用.ch02_2_运算符._24_用三元运算符判断奇数和偶数;

import java.util.Scanner;

/**
 * 024 用三元运算符判断奇数和偶数
 */
public class ParityCheck {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Scanner scan = new Scanner( System.in );    // 创建输入流扫描器
		System.out.println( "请输入一个整数：" );
		long number = scan.nextLong();            // 获取用户输入的整数

		String check = ( number % 2 == 0 ) ? "这个数字是:偶数" : "这个数字是：奇数";

		System.out.println( check );

	}

}
