package bj.Java1200.col01.ch05_面向对象技术应用.ch05_5_Object类的应用._108_简化toString方法的重写;

import java.awt.*;

public class Test108 {

	public static void main( String[] args ) {

		Cat108 cat1 = new Cat108( "Java", 12, 21, Color.BLACK );
		Cat108 cat2 = new Cat108( "C++", 12, 21, Color.WHITE );
		Cat108 cat3 = new Cat108( "Java", 12, 21, Color.BLACK );

		System.out.println( "猫咪1号：" + cat1 );
		System.out.println( "猫咪2号：" + cat2 );
		System.out.println( "猫咪3号：" + cat3 );

	}

}
