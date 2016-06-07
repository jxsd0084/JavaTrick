package bj.mldn.javase01.no25;

public class ObjectDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String arg[] ) {

		int    i[] = { 1, 2, 3, 4, 5, 6, 7, 8 };    // 数组

		Object obj = i;    // 使用Object接收数组

		int    x[] = (int[]) obj;    // 向下转型
		for ( int j = 0; j < x.length; j++ ) {

			System.out.print( x[ j ] + "、" );
		}

	}

}
