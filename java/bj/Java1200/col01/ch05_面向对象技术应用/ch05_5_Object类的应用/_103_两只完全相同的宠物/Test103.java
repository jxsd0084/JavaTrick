package bj.Java1200.col01.ch05_面向对象技术应用.ch05_5_Object类的应用._103_两只完全相同的宠物;

import java.awt.*;

public class Test103 {

	public static void main( String[] args ) {

		Cat103 cat1 = new Cat103( "Java", 12, 21, Color.BLACK );
		Cat103 cat2 = new Cat103( "C++", 12, 21, Color.WHITE );
		Cat103 cat3 = new Cat103( "Java", 12, 21, Color.BLACK );

		System.out.println( "猫咪1号：" + cat1 );
		System.out.println( "猫咪2号：" + cat2 );
		System.out.println( "猫咪3号：" + cat3 );
		System.out.println( "猫咪1号是否与猫咪2号相同：" + cat1.equals( cat2 ) );
		System.out.println( "猫咪1号是否与猫咪3号相同：" + cat1.equals( cat3 ) );
	}

}
