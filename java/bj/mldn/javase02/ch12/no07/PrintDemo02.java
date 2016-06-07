package bj.mldn.javase02.ch12.no07;

import java.io.*;

public class PrintDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String arg[] ) throws Exception {

		PrintStream ps = null;        // 声明打印流对象


		// 如果现在是使用FileOuputStream实例化，意味着所有的输出是向文件之中
		ps = new PrintStream( new FileOutputStream( new File( "d:" + File.separator + "test.txt" ) ) );


		String name  = "李兴华";       // 定义字符串
		int    age   = 30;            // 定义整数
		float  score = 990.356f;      // 定义小数
		char   sex   = 'M';           // 定义字符


		ps.printf( "姓名：%s；年龄：%d；成绩：%f；性别：%c", name, age, score, sex );


		ps.close();
	}
}
