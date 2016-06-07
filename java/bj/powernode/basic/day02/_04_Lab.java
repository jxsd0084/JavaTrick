package bj.powernode.basic.day02;

public class _04_Lab {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		//  逻辑运算符

		//  逻辑非 !  (取反)
		//  逻辑与 &  (两者为true,才是true)
		//  逻辑或 |  (两者中只要有一个为true,结果就是true)
		//  逻辑异或 ^ (两者不一样就为 true)

		//  短路与 && (两者为true,才是true)
		//  短路或 || (两者中只要有一个为true,结果就是true)

		boolean a1 = true;
		boolean a2 = false;

		boolean r1 = a1 & a2;

		System.out.println( "r1=" + r1 );  //false







		boolean r2 = a1 | a2;

		System.out.println( "r2=" + r2 ); //true







		boolean r3 = a1 ^ a2;

		System.out.println( "r3=" + r3 );  //true







		// ||

		int i1 = 10;
		int i2 = 12;

		if ( i1 > 5 || ( ++ i2 ) > 10 ) {

			System.out.println( "测试短路与" );
		}

		System.out.println( "i2=" + i2 );  // 13 还是 12






		// |

		int i3 = 10;
		int i4 = 12;
		if ( i3 > 5 | ( ++ i4 ) > 10 ) {

			System.out.println( "测试逻辑或" );
		}

		System.out.println( "i4=" + i4 );  // 13 还是 12


		// &&  短路与





	}

}
