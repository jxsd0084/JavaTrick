package bj.jakeChen.Guava.Collection;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

import java.util.Map;

/**
 * Created by chenlong on 2016/4/25.
 */
public class TestImmutableMap {

	public static void main( String[] args ) {

		ImmutableMap< String, String > map = ImmutableMap.of( "key1", "value1", "key2", "value2" );
		ImmutableSet< Map.Entry< String, String > > entries = map.entrySet();
		UnmodifiableIterator< Map.Entry< String, String > > it = entries.iterator();
		while ( it.hasNext() ){
			System.out.println("ImmutableMap -> " + it.next());
		}
	}

}
