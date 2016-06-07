package bj.Java1200.col01.ch05_面向对象技术应用.ch05_2_修饰符的使用._090_统计图书的销售量;

import java.util.Random;

public class BookTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		String[] titles = { "《Java从入门到精通（第2版）》", "《Java编程词典》", "《视频学Java》" };

		for ( int i = 0; i < 5; i++ ) {

			new Book( titles[ new Random().nextInt( 3 ) ] );
		}

		System.out.println( "总计销售了" + Book.getCounter() + "本图书！" );

	}

}
