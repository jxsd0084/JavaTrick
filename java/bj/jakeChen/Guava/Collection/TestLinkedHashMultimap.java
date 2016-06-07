package bj.jakeChen.Guava.Collection;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multiset;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenlong on 2016/4/25.
 */
public class TestLinkedHashMultimap {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		LinkedHashMultimap< String, Integer > current = LinkedHashMultimap.create();
		current.put( "1", 1 );
		current.put( "2", 2 );
		current.put( "3", 3 );
		Multiset< String > keys = current.keys();
		System.out.println( "keys -> " + keys );

		Set< String > keySet = current.keySet();
		System.out.println( "keySet -> " + keySet );

		boolean b = current.containsKey( "2" );
		System.out.println( "b -> " + b );

		b = current.containsValue( 3 );
		System.out.println( "b -> " + b );

		Set< Integer > val = current.get( "1" );
		System.out.println( "val -> " + val );

		Set< Map.Entry< String, Integer > >      entries  = current.entries();
		Iterator< Map.Entry< String, Integer > > iterator = entries.iterator();
		while ( iterator.hasNext() ) {
			System.out.println( "iterator -> " + iterator.next() );
		}
	}

}
