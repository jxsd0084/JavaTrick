package bj.powernode.basic.day12.方法中如何传递不定的参数;

public class Test {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		m( "jack", "sun", "lucy", "jim" );

	}


	// String[] 不定长度的String类型的数组.
	public static void m( String... strs ) {

		System.out.println( strs.length );

		for ( int i = 0; i < strs.length; i++ ) {

			System.out.print( strs[ i ] + " " );
		}
	}

	// 不定长度的Object类型数组
	public static void m2( Object... objs ) {

	}

	// 不定长度的int类型数组.
	public static void m3( int... ints ) {

	}
	
	/*
	// 结论: Type...   参数必须出现在参数列表的最后一位
	public static void m4(int... ints,int i){
	
	}
	*/

	// 允许
	public static void m5( int i, int... ints ) {

	}

}
