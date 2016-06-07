package bj.Java1200.col01.ch02_Java基础应用.ch02_1_基本语法._20_从控制台接受字符串;

import java.util.Scanner;

/**
 * 020 从控制台接受字符串
 */
public class InputCode {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Scanner scanner = new Scanner( System.in ); // 创建输入流扫描器
		System.out.println( "请输入你的身份证号：" );  // 提示用户输入
		String line = scanner.nextLine();           // 获取用户输入的一行文本

		// 打印对输入文本的描述
		System.out.println( "原来你身份证号是" + line.length() + "位数字的啊" );
	}

}
