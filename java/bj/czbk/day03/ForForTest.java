package bj.czbk.day03;/*

*
**
***
****
*****


1
12
123
1234
12345



九九乘法表
1*1=1
1*2=2 2*2=4
1*3=3 2*3=6 3*3=9


*/

class ForForTest {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		/*

		*
		**
		***
		****
		*****

		不是规律的规律：

		尖朝上，可以改变条件。让条件随着外循环变化。

		尖朝下，可以初始化值，让初始化随着外循环变化。

		*/

		for ( int x = 0; x < 5; x++ ) {
			for ( int y = 0; y <= x; y++ ) {
				System.out.print( "*" );
			}
			System.out.println();
		}

		System.out.println( "----------------------" );

		/*

		1
		12
		123
		1234
		12345

		*/

		for ( int x = 1; x <= 5; x++ ) {
			for ( int y = 1; y <= x; y++ ) {
				System.out.print( y );
			}
			System.out.println();
		}

		System.out.println( "----------------------" );


		/*

		九九乘法表
		1*1=1
		1*2=2 2*2=4
		1*3=3 2*3=6 3*3=9

		*/

		for ( int x = 1; x <= 9; x++ ) {
			for ( int y = 1; y <= x; y++ ) {
				System.out.print( y + "*" + x + "=" + y * x + "\t" );
			}
			System.out.println();
		}

	}
}


