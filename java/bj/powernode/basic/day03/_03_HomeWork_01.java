package bj.powernode.basic.day03;

public class _03_HomeWork_01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		int count = 0; //   计数

		//  找出1-100以内可以被3整除的数.

		for ( int i = 1; i <= 100; i++ ) {

			if ( i % 3 == 0 ) {

				++ count;

				System.out.println( i );
			}

			if ( count == 5 ) {

				break;
			}

		}

	}

}
