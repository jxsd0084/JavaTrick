package bj.mldn.javase01.no77.Collection.mapdemo;

import java.util.HashMap;
import java.util.Map;

public class HashMapPersonDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Map< String, Person > map = new HashMap< String, Person >();
		map.put( new String( "zs" ), new Person( "张三", 30 ) );
		System.out.println( map.get( new String( "zs" ) ) );
	}

}
