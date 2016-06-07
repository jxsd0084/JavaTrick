package bj.hmkcode.MapSort;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/1.
 */
class ValueComparator implements Comparator {

	Map map;

	public ValueComparator( Map map ) {

		this.map = map;
	}

	@Override
	public int compare( Object keyA, Object keyB ) {

		Comparable valueA = (Comparable) map.get( keyA );
		Comparable valueB = (Comparable) map.get( keyB );

		System.out.println( valueA + " - " + valueB );

		return valueA.compareTo( valueB );
	}


}
