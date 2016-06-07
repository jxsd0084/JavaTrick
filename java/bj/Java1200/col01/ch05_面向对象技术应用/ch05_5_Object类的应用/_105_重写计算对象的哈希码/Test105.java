package bj.Java1200.col01.ch05_面向对象技术应用.ch05_5_Object类的应用._105_重写计算对象的哈希码;

import java.awt.*;

public class Test105 {

	public static void main( String[] args ) {

		Cat105 cat1 = new Cat105( "Java", 12, 21, Color.BLACK );
		Cat105 cat2 = new Cat105( "C++", 12, 21, Color.WHITE );
		Cat105 cat3 = new Cat105( "Java", 12, 21, Color.BLACK );

		System.out.println( "猫咪1号的哈希码：" + cat1.hashCode() );
		System.out.println( "猫咪2号的哈希码：" + cat2.hashCode() );
		System.out.println( "猫咪3号的哈希码：" + cat3.hashCode() );

		System.out.println( "猫咪1号是否与猫咪2号相同：" + cat1.equals( cat2 ) );
		System.out.println( "猫咪1号是否与猫咪3号相同：" + cat1.equals( cat3 ) );

	}

}
