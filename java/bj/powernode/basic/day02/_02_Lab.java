package bj.powernode.basic.day02;

public class _02_Lab {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		//  运算符

		//  算术运算符
		//	+ - * / % ++ --

		// %
		int i1 = 8;
		int i2 = 3;

		int result1 = i1 % i2;

		System.out.println( "result1=" + result1 );





		//  ++ (左++)
		int i3 = 8;
		++ i3;
		System.out.println( "i3=" + i3 );





		int i4 = 10;
		int i5 = ++ i4;  // i4先自加1,将结果赋值给 i5

		System.out.println( "i4=" + i4 );  // 11
		System.out.println( "i5=" + i5 );  // 11






		//  ++ (右++)
		int i6 = 1;
		i6++;
		System.out.println( "i6=" + i6 );  //2





		int i7 = 1;
		int i8 = i7++;  //  先将i7的值赋值给i8,然后i7再加1
		System.out.println( "i7=" + i7 ); // 2
		System.out.println( "i8=" + i8 ); // 1


		//  -- (左--)


		//  -- (右--)


	}

}
