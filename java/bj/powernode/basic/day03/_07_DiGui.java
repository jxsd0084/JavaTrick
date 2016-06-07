package bj.powernode.basic.day03;

//  方法的递归调用.
//  方法调用自身.

//  方法递归调用必须要有结束的条件,要不然就会   “内存溢出”

//  用递归实现从 10-1 的输出.

public class _07_DiGui {

	public static void m( int i ) {

		if ( i == 0 ) {
			return;
		}

		System.out.println( i );

		_07_DiGui.m( i - 1 );

		System.out.println( "end" );

	}

	public static void m1( int i ) {

		if ( i == 0 ) {
			return;
		}
		System.out.println( i );

		i--;

		if ( i == 0 ) {
			return;
		}

		System.out.println( i );

		i--;

		if ( i == 0 ) {
			return;
		}

		System.out.println( i );

		i--;

		if ( i == 0 ) {
			return;
		}

		System.out.println( i );
		i--;

		if ( i == 0 ) {
			return;
		}

		System.out.println( i );
		i--;

		if ( i == 0 ) {
			return;
		}

		System.out.println( i );
		i--;

		if ( i == 0 ) {
			return;
		}

		System.out.println( i );
		i--;

		if ( i == 0 ) {
			return;
		}

		System.out.println( i );
		i--;

		if ( i == 0 ) {
			return;
		}

		System.out.println( i );


		i--;

		if ( i == 0 ) {
			return;
		}

		System.out.println( i );


	}


	//  程序的入口
	public static void main( String[] args ) {

		_07_DiGui.m( 10 );

		_07_DiGui.m1( 10 );

	}

}
