package bj.jakeChen.Guava.Collection;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenlong on 2016/4/25.
 */
public class TestMap {

	public static void main( String[] args ) {

		HashMap< String, Integer > mapA = new HashMap< String, Integer >();
		mapA.put( "1", 1 );
		mapA.put( "2", 2 );
		mapA.put( "3", 3 );

		HashMap< String, Integer > mapB = new HashMap< String, Integer >();
		mapB.put( "1", 1 );
		mapB.put( "2", 2 );
		mapB.put( "3", 3 );
		mapB.put( "4", 4 );

		MapDifference differenceMap = Maps.difference( mapA, mapB );

		boolean b = differenceMap.areEqual();
		System.out.println( "areEqual -> " + b );

		Map      entriesDiffering = differenceMap.entriesDiffering();
		Set      set              = entriesDiffering.entrySet();
		Iterator iterator         = set.iterator();
		while ( iterator.hasNext() ) {
			System.out.println( "entriesDiffering -> " + iterator.next() );
		}

		Map entriesOnlyOnLeft = differenceMap.entriesOnlyOnLeft();
		set = entriesOnlyOnLeft.entrySet();
		iterator = set.iterator();
		while ( iterator.hasNext() ) {
			System.out.println( "entriesOnlyOnLeft -> " + iterator.next() );
		}

		Map entriesOnlyOnRight = differenceMap.entriesOnlyOnRight();
		set = entriesOnlyOnRight.entrySet();
		iterator = set.iterator();
		while ( iterator.hasNext() ) {
			System.out.println( "entriesOnlyOnRight -> " + iterator.next() );
		}

		Map entriesInCommon = differenceMap.entriesInCommon();
		set = entriesInCommon.entrySet();
		iterator = set.iterator();
		while ( iterator.hasNext() ) {
			System.out.println( "entriesInCommon -> " + iterator.next() );
		}

	}

}
