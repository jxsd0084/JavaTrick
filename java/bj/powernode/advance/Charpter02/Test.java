package bj.powernode.advance.Charpter02;

public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		byte b = 10;
		b += 12;
		b = (byte) ( b + 12 );
		System.out.println( "b=" + b );


		String s1 = "Hello";
		String s2 = "World";
		s1 += s2;
		s1 = s1 + s2;


		int    i = 9;
		String s = ( i > 10 ) ? "i大于10成立" : "i大于10不成立";


		int score = 70;
		if ( score < 60 ) {
			System.out.println( "不及格" );

		} else if ( score < 70 ) {
			System.out.println( "及格" );

		} else if ( score < 90 ) {
			System.out.println( "良" );

		} else {
			System.out.println( "优" );

		}


		if ( score < 60 ) {
			System.out.println( "你要好好努力了" );

		} else {
			System.out.println( "还凑合!" );

		}


		// switch里面需要的是和int兼容的整形数据
		// 也就是能自动的转换为int的整形数据
		// byte ,short ,char,int
		int score2 = 70;
		switch ( score2 ) {
			// case 分支里面的每个常量必须不同!
			case 60:
				System.out.println( "60" );
				break;

			case 70:
				System.out.println( "70" );
				break;

			case 80:
				System.out.println( "80" );
				break;

			case 90:
				System.out.println( "90" );
				break;

			// default语句可有可无,并且可以在任意的位置
			default:
				System.out.println( "其他" );
				break;

		}


		// for循环

		int sum2 = 0;
		for ( int i2 = 1; i2 <= 10; i2++ ) {
			sum2 += i2;
		}


		// while 循环
		int sum3 = 0;
		int i3   = 1;
		while ( i3 <= 10 ) {
			sum3 += i3;
			i3++;
		}

/*

		for (; ; ) {
			System.out.println( "=================" );
		}


		while ( true ) {
			System.out.println( "======+++++++++++++++++===========" );
		}
*/


		for ( int i4 = 1, j = 10; i4 <= 10; i4++, j-- ) {
			System.out.println( "i=" + i4 + "  j=" + j );
		}


		int sum5 = 0;
		int i5   = 11;
		do {
			sum5 += i5;
			i5++;
		} while ( i5 <= 10 );


		for ( int i6 = 0; i6 < 10; i6++ ) {
			System.out.println( "i=--------------------------------------" + i6 );
			for ( int j = 0; j < 100; j++ ) {
				if ( j == 40 ) {
					// break中断和他最近的循环
					break;
				}

				if ( j % 10 == 0 ) {
					// continue 终止本次循环,直接进入下一次循环
					continue;
				}
				System.out.println( "             j=" + j );
			}
		}
		System.out.println( "sum=" + sum5 );

	}

}
