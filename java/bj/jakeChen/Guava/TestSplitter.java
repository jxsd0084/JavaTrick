package bj.jakeChen.Guava;

import com.google.common.base.Splitter;
import com.google.common.primitives.Ints;

import java.util.Iterator;

/**
 * Created by chenlong on 2016/4/25.
 */
public class TestSplitter {

	public static void main( String[] args ) {

		String   numbsAsString = "a,b,c,d,e,f";
		Iterable split         = Splitter.on( "," ).split( numbsAsString );
		Iterator iterator      = split.iterator();
		while ( iterator.hasNext() ) {
			System.out.println( "Splitter.on -> " + iterator.next() );
		}

		System.out.println();

		String             testString = "foo , what,,,more,";
		Iterable< String > split2     = Splitter.on( "," ).omitEmptyStrings().trimResults().split( testString );
		Iterator< String > iterator1  = split2.iterator();
		while ( iterator1.hasNext() ) {
			System.out.println( "Splitter.on -> " + iterator1.next() );
		}

		System.out.println();

		int[]   array    = { 1, 2, 3, 4, 5 };
		int[]   array2   = { 10, 11, 12 };
		int     a        = 4;
		boolean contains = Ints.contains( array, a );
		System.out.println( "Ints.contains -> " + contains );

		int indexOf = Ints.indexOf( array, a );
		System.out.println( "Ints.indexOf -> " + indexOf );

		int max = Ints.max( array );
		System.out.println( "Ints.max -> " + max );

		int min = Ints.min( array );
		System.out.println( "Ints.min -> " + min );

		int[] concat = Ints.concat( array, array2 );
		for ( int i = 0; i < concat.length; i++ ) {
			System.out.println( "Ints.concat -> " + concat[i] );
		}

	}

}
