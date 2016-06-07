package bj.JavaAlgorithm.basic.P13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class test39 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		int i, j, k, m, n, t1, t2, t3;
		Set total = new HashSet();
		for ( int t = 1; t < 10; t++ ) {
			total.add( t );
		}
		Set set       = new HashSet();
		Set lastThree = new HashSet();
		for ( i = 1; i < 4; i++ ) {
			set.add( i );
			for ( j = 1; j < 10; j++ ) {
				if ( j == i ) {
					continue;
				}
				set.add( j );
				for ( k = 1; k < 10; k++ ) {
					if ( k == i || k == j ) {
						continue;
					}
					set.add( k );
					m = 3 * ( i * 100 + j * 10 + k );
					if ( m > 987 ) {
						set.remove( k );
						continue;
					}//如果已超出范围，没必要再往下判断 
					t1 = m % 10;
					if ( t1 == 0 ) {
						set.remove( k );
						continue;
					} //个位数 
					t2 = ( m % 100 ) / 10;
					if ( t2 == 0 ) {
						set.remove( k );
						continue;
					} //十位数 
					t3 = m / 100;
					if ( t3 == 0 ) {
						set.remove( k );
						continue;
					}//百位数 
					if ( set.contains( t1 ) ) {
						set.remove( k );
						continue;
					}
					set.add( t1 );
					if ( set.contains( t2 ) ) {
						set.remove( k );
						set.remove( t1 );
						continue;
					}
					set.add( t2 );
					if ( set.contains( t3 ) ) {
						set.remove( k );
						set.remove( t1 );
						set.remove( t2 );
						continue;
					}
					set.add( t3 );

					total.removeAll( total );
					for ( int q = 1; q < 10; q++ ) {
						total.add( q );
					}
					total.removeAll( set );
					int[]    s        = new int[ 3 ];
					Iterator iterator = total.iterator();
					int      p        = 0;
					while ( iterator.hasNext() ) {
						s[ p ] = Integer.parseInt( iterator.next() + "" );
						p++;
					}
					n = s[ 0 ] * 100 + s[ 1 ] * 10 + s[ 2 ];
					if ( n == 2 * ( i * 100 + j * 10 + k ) ) {
						System.out.println( i + "" + j + "" + k + "    " + n + "    " + m );
					}
					n = s[ 0 ] * 100 + s[ 2 ] * 10 + s[ 1 ];
					if ( n == 2 * ( i * 100 + j * 10 + k ) ) {
						System.out.println( i + "" + j + "" + k + "    " + n + "    " + m );
					}
					n = s[ 1 ] * 100 + s[ 0 ] * 10 + s[ 2 ];
					if ( n == 2 * ( i * 100 + j * 10 + k ) ) {
						System.out.println( i + "" + j + "" + k + "    " + n + "    " + m );
					}
					n = s[ 1 ] * 100 + s[ 2 ] * 10 + s[ 0 ];
					if ( n == 2 * ( i * 100 + j * 10 + k ) ) {
						System.out.println( i + "" + j + "" + k + "    " + n + "    " + m );
					}
					n = s[ 2 ] * 100 + s[ 0 ] * 10 + s[ 1 ];
					if ( n == 2 * ( i * 100 + j * 10 + k ) ) {
						System.out.println( i + "" + j + "" + k + "    " + n + "    " + m );
					}
					n = s[ 2 ] * 100 + s[ 1 ] * 10 + s[ 0 ];
					if ( n == 2 * ( i * 100 + j * 10 + k ) ) {
						System.out.println( i + "" + j + "" + k + "    " + n + "    " + m );
					}
					set.remove( t1 );
					set.remove( t2 );
					set.remove( t3 );
					set.remove( k );
				}
				set.remove( j );
			}
			set.remove( i );
		}
	}
} 

