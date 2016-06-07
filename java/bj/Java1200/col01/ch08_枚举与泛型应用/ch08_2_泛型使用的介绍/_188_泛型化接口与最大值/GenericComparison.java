package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._188_泛型化接口与最大值;

public class GenericComparison < T extends Comparable< T > > implements Maximum< T > {

	@Override
	public T getMax( T[] array ) {

		if ( array == null || array.length == 0 ) {
			return null;
		}
		T max = array[ 0 ];
		for ( int i = 1; i < array.length; i++ ) {
			if ( max.compareTo( array[ i ] ) < 0 ) {
				max = array[ i ];
			}
		}
		return max;
	}
}
