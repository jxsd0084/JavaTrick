package bj.jakeChen.Guava.Collection;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlong on 2016/4/25.
 */
public class TestImmutableList {

	public static void main( String[] args ) {

		// JDK
		List< String > list = new ArrayList< String >();
		list.add( "a" );
		list.add( "b" );
		list.add( "c" );
		list.add( "d" );
		for ( String str : list ) {
			System.out.println( "list -> " + str );
		}

		// Guava
		ImmutableList< String > of = ImmutableList.of( "a", "b", "c", "d" );
		for ( String str : of ) {
			System.out.println( "ImmutableList -> " + of );
		}

	}

}
