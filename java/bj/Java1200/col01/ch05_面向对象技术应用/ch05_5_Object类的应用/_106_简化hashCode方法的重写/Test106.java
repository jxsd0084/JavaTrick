package bj.Java1200.col01.ch05_面向对象技术应用.ch05_5_Object类的应用._106_简化hashCode方法的重写;

import java.awt.*;

public class Test106 {

	public static void main( String[] args ) {

		Cat106 cat1 = new Cat106( "Java", 12, 21, Color.BLACK );
		Cat106 cat2 = new Cat106( "C++", 12, 21, Color.WHITE );
		Cat106 cat3 = new Cat106( "Java", 12, 21, Color.BLACK );

		System.out.println( "猫咪1号的哈希码：" + cat1.hashCode() );
		System.out.println( "猫咪2号的哈希码：" + cat2.hashCode() );
		System.out.println( "猫咪3号的哈希码：" + cat3.hashCode() );

		System.out.println( "猫咪1号是否与猫咪2号相同：" + cat1.equals( cat2 ) );
		System.out.println( "猫咪1号是否与猫咪3号相同：" + cat1.equals( cat3 ) );

	}

}
