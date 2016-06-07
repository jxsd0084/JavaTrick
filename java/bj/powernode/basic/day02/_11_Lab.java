package bj.powernode.basic.day02;

public class _11_Lab {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {


		//  break;

		//  当i==5的时候结束break所在的循环.
		for ( int i = 0; i < 10; i++ ) {

			if ( i == 5 ) {

				break;
			}

			System.out.println( i );

		}






		//  continue

		//  当i==5的时候,结束当前的本次循环,进入下一次循环.
		for ( int i = 0; i < 10; i++ ) {

			if ( i == 5 ) {

				continue;
			}

			System.out.println( i );  // 0 1 2 3 4 6 7 8 9

		}


	}

}
