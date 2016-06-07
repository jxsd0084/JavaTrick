package bj.hmkcode.MapSort;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2016/6/1.
 */
public class MapSort {

	public static Map sortByValue( Map unsortedMap ) {

		Map sortedMap = new TreeMap( new ValueComparator( unsortedMap ) );
		sortedMap.putAll( unsortedMap );
		return sortedMap;
	}

	public static Map sortByKey( Map unsortedMap ) {

		Map sortedMap = new TreeMap();
		sortedMap.putAll( unsortedMap );
		return sortedMap;
	}

}
