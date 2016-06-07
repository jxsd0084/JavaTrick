package bj.mldn.javase02.ch06.no11;

public class ObjectDemo05 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {
		int    temp[] = { 1, 3, 5, 7, 9 };    // 定义数组
		Object obj    = temp;    // 使用Object接收数组
		print( obj );
	}

	public static void print( Object o ) {
		if ( o instanceof int[] ) {        // 判断是否是整型数组
			int x[] = (int[]) o;
			for ( int i = 0; i < x.length; i++ ) {
				System.out.print( x[ i ] + "\t" );
			}
		}
	}
}
