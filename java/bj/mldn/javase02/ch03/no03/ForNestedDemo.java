package bj.mldn.javase02.ch03.no03;

public class ForNestedDemo {

	// 完成一个四则运算的功能
	public static void main( String args[] ) {

		for ( int i = 1; i <= 9; i++ ) {        // 控制行
			for ( int j = 1; j <= i; j++ ) {    // 控制列
				System.out.print( i + "*" + j + "=" + ( i * j ) + "\t" );
			}
			System.out.println();
		}
	}
}
