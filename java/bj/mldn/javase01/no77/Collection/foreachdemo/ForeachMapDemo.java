package bj.mldn.javase01.no77.Collection.foreachdemo;

import java.util.HashMap;
import java.util.Map;

public class ForeachMapDemo {

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
		for ( Map.Entry< String, Integer > me : map.entrySet() ) {
			System.out.println( me.getKey() + " --> " + me.getValue() );
		}
	}
}
