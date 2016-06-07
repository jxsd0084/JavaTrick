package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._187_泛型化方法与最小值;

public class GenericComparison {

	public static < T extends Comparable< T > > T getMin( T[] array ) {

		if ( array == null || array.length == 0 ) {
			return null;
		}
		T min = array[ 0 ];

		for ( int i = 1; i < array.length; i++ ) {
			if ( min.compareTo( array[ i ] ) > 0 ) {
				min = array[ i ];
			}
		}
		return min;
	}

}
