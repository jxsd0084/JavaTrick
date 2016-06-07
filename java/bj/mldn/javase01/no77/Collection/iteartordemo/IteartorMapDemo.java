package bj.mldn.javase01.no77.Collection.iteartordemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IteartorMapDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Map< String, Integer > map = new HashMap< String, Integer >();
		map.put( "zhangsan", 1 );
		map.put( "zhangsan", 2 );
		map.put( "lisi", 3 );
		map.put( "wangwu", 5 );
		Set< Map.Entry< String, Integer > > allSet = null;
		allSet = map.entrySet();
		Iterator< Map.Entry< String, Integer > > iter = allSet.iterator();
		while ( iter.hasNext() ) {
			Map.Entry< String, Integer > me = iter.next();
			System.out.println( me.getKey() + " --> " + me.getValue() );
		}
	}
}
