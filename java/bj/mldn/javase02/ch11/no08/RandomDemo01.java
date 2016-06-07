package bj.mldn.javase02.ch11.no08;

import java.util.Random;

public class RandomDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Random r = new Random();        // 实例化Random对象
		for ( int i = 0; i < 10; i++ ) {
			System.out.print( r.nextInt( 100 ) + "\t" );
		}


	}


}
