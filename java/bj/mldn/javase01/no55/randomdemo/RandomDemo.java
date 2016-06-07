package bj.mldn.javase01.no55.randomdemo;

import java.util.Random;

public class RandomDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Random r = new Random();
		for ( int i = 0; i < 10; i++ ) {

			System.out.print( r.nextInt( 100 ) + "、" );
		}

	}

}
