package bj.Java1200.col01.ch05_面向对象技术应用.ch05_5_Object类的应用._107_使用字符串输出对象;

import java.awt.*;

public class Test107 {

	public static void main( String[] args ) {

		Cat107 cat1 = new Cat107( "Java", 12, 21, Color.BLACK );
		Cat107 cat2 = new Cat107( "C++", 12, 21, Color.WHITE );
		Cat107 cat3 = new Cat107( "Java", 12, 21, Color.BLACK );

		System.out.println( "猫咪1号：" + cat1 );
		System.out.println( "猫咪2号：" + cat2 );
		System.out.println( "猫咪3号：" + cat3 );

	}

}
