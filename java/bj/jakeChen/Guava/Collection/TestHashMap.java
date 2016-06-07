package bj.jakeChen.Guava.Collection;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * Created by chenlong on 2016/4/25.
 */
public class TestHashMap {

	public static void main( String[] args ) {
		// JDK
		Map< String, Map< Long, List< String > > > map1 = new HashMap< String, Map< Long, List< String > > >();
		Set< Map.Entry< String, Map< Long, List< String > > > > entries = map1.entrySet();
		Iterator< Map.Entry< String, Map< Long, List< String > > > > iterator = entries.iterator();
		while ( iterator.hasNext() ){
			System.out.println("JDK -> " + iterator.next());
		}

		// Guava
		Map< String, Map< Long, List< String > > > map2 = Maps.newHashMap();
		Set< Map.Entry< String, Map< Long, List< String > > > > entries1 = map2.entrySet();
		Iterator< Map.Entry< String, Map< Long, List< String > > > > iterator1 = entries1.iterator();
		while ( iterator1.hasNext() ){
			System.out.println("Guava -> " + iterator1.next());
		}
	}

}
