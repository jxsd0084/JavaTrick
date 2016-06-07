package bj.powernode.advance.Charpter01;

// 类名的首字符必须要大写

// 可以以字符,_,$ 开头,后面可以跟上字符,数字等正常字符

// 并且不能加空格

// 标示符不能是java的关键字

// 所有的关键字都是小写的

/*public*/ class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		final String s = "Hellofjsdlfjdslkfjdlkjfdlskjfldskjfdslkjfsklfjdslkfjsklfjsl";
		String       S = "Worldfjdlsfjldsjflskfjlskfjskljfdkfjjjjsklfjsklfjdslkfjfklsjflskjflskjflskjflskjfslkjfslkdk";
		S = null;
//		String null = "NULL";
		System.out.println( s + S );


		byte b1 = - 127;
		System.out.println( b1 );


		char c1 = '中';
		char 字符 = '人';
		System.out.println( 字符 );





		// java里面默认的把char类型当做int类型来处理
		int i = 97;

		char c2 = 'a';
		if ( c2 == 97 ) {
			System.out.println( "c1== 97" );
		}





		// 局部变量
		// 局部变量必须要被显示的初始化
		int i2 = 0x10;
		System.out.println( i );





		// 对于整形常量来说,java把他默认的当做int类型来处理
		byte b2 = 10;
		long l1 = 10L;
		System.out.println( l1 );





		// 有小数点的数据默认的都是double类型
		double d1 = 3.14;
		System.out.println( d1 );


		System.out.println( "18/0 =" + ( 18 / 0 ) );
		System.out.println( "18.0/0.0 =" + ( 18.0 / 0.0 ) );
		System.out.println( "0.0/0 =" + ( 0.0 / 0 ) );





		// == 在这里比较的是两个基本类型的值是否相等
		if ( ( 0.0 / 0 ) == ( 0.0 / 0 ) ) {
			System.out.println( "ok" );

		} else {
			System.out.println( "not ok" );

		}




		// java 里面的double类型是不精确的
		if ( ( 2.0 - 1.1 ) == 0.9 ) {
			System.out.println( "ok" );

		} else {
			System.out.println( "not ok" + ( 2.0 - 1.1 ) );

		}





		// 有小数点的数据默认的都是double类型
		float f1 = 3.4F;
		System.out.println( f1 );





		// 对浮点数的精度要求不是很高的情况下,可以使用float
		if ( ( 2.0f - 1.1f ) == 0.9f ) {

			System.out.println( "ok" );
		}





		// boolean只能有两种取值,true/false
		// 只能出现在逻辑表达式中
		boolean b3 = false;
		if ( b3 ) {
			System.out.println( "真" );

		} else {
			System.out.println( "假" );

		}

		int i3 = 10;
//		if ( i3 ) {
//			System.out.println( "真" );
//		}





		// 8中基本类型之中,除了boolean之外,其他的七种基本类型可以在一起运算
		// byte ,short ,char ,int ,long ,float,double
		byte   b4 = 10;
		short  s4 = 2;
		char   c4 = 'a';
		int    i4 = 30;
		long   l4 = 10L;
		float  f4 = 3.2f;
		double d4 = 3.4;





		// 在算数表达式中有double类型,则返回肯定是double类型
//		int i5 = b4 + s4 + c4 + i4 + l4 + f4 + d4;
		double d5 = b4 + s4 + c4 + i4 + l4 + f4 + d4;





		//在算数表达式中没有double类型但是有float,则返回肯定是float类型
		float f5 = b4 + s4 + c4 + i4 + l4 + f4;





		//在算数表达式中没有double ,floa类型但是有long,则返回肯定是long类型
		long l5 = b4 + s4 + c4 + i4 + l4;





		// 在整形算数表达式中没有long,则返回肯定是int
		int i5 = b4 + s4 + c4;





		// 把大数据装入到小数据的时候,需要进行强制类型转换
		int  I = 100;
		byte B = (byte) I;






		//把小数据装入到大数据的时候,会进行自动类型转换
		byte bb = 10;
		int  ii = bb;


		byte b6 = 10;
		byte b7 = 13;
		byte b8 = (byte) ( b1 + b2 );


		int i7 = 15 % 4;
		System.out.println( i7 );


		int i8 = 10;
		int i9 = 100;
		if ( i8 != i9 ) {

			System.out.println( "ok" );
		}




		// 把int型数据进行位移的时候,首先将操作数对32取模,得到的数才是真正的操作数

		// 对于低于int型的整形,进行位移的时候,首先将数据自动的转圜为int类型
		char c6 = 8;
		int  j = c6 >> 33;
		System.out.println( j );





		// 把long型数据进行位移的时候,首先将操作数对64取模,得到的数才是真正的操作数
		long l  = 8L;
		long l2 = l >> 129;
		System.out.println( l2 );





	}

}
