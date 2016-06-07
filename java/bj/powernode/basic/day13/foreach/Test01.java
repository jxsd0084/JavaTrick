package bj.powernode.basic.day13.foreach;

/*

	JDK 1.5之后的增强for循环
	
	For Each
	
	语法:
		for(类型名 对象名 : 集合|数组){

			System.out.println(对象名);
		}

*/

public class Test01 {

	public static void main( String[] args ) {

		int[] ins = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		// 传统的for循环
		for ( int i = 0; i < ins.length; i++ ) {

			System.out.println( ins[ i ] );
		}

		System.out.println( "=============================" );

		// forEach
		for ( int i : ins ) {  // i是ins集合或数组中的某个元素.

			System.out.println( i );
		}


	}

}

