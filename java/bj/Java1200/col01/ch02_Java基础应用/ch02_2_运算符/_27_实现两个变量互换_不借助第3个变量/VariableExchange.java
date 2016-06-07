package bj.Java1200.col01.ch02_Java基础应用.ch02_2_运算符._27_实现两个变量互换_不借助第3个变量;

import java.util.Scanner;

/**
 * 027 实现两个变量互换 ( 不借助第3个变量 )
 */
public class VariableExchange {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Scanner scan = new Scanner( System.in );// 创建扫描器

		System.out.println( "请输入变量A的值" );
		long A = scan.nextLong();               // 接收第一个变量值
		System.out.println( "请输入变量B的值" );

		long B = scan.nextLong();               // 接收第二个变量值
		System.out.println( "A=" + A + "\tB=" + B );
		System.out.println( "执行变量互换..." );
		A = A ^ B;                              // 执行变量互换
		B = B ^ A;
		A = A ^ B;
		System.out.println( "A=" + A + "\tB=" + B );

	}

}
