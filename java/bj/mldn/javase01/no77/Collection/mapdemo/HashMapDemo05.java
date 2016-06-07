package bj.mldn.javase01.no77.Collection.mapdemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo05 {

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
		Collection< Integer > col  = map.values();    // 取得全部value
		Iterator< Integer >   iter = col.iterator();
		while ( iter.hasNext() ) {
			Integer value = iter.next();
			System.out.println( value );
		}
	}

}
