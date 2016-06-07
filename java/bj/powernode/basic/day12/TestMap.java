package bj.powernode.basic.day12;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/*

	java.util.Map; <<interface>>
		java.util.HashMap; (impl_class)
	
	Map<key,Value>.
	
	key部分是一个Set集合.
	
	存入到key的元素需要重写 equals,hashCode方法.
	
	需要掌握的方法:

		1.清空			map.clear()
		2.通过key获取value	value = map.get(key);
		3.获取key部分		Set s = map.keySet();
		4.获取value部分		Collection c = map.values();
		5.获取集合长度		map.size();
		6.添加元素.		map.put(key,value);
		7.判断是否为空		map.isEmpty();
		8.判断该集合中是否包含某个key	map.containsKey(key);
		9.判断集合中是否包含某些value.  map.containsValue(value);
		10.通过key删除value. map.remove(key);
		
	
	注意: Map中的key和value都需要重写equals,hashCode方法.
	
	
	向Map中添加元素的时候,如果key值重复,则将原来的value更新覆盖.


*/
public class TestMap {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {


		// 测试java.util.HashMap




		// 1.初始化
		Map maps = new HashMap();





		// 2.添加元素
		maps.put( "1001", "jack" );
		maps.put( "1002", "sun" );
		maps.put( "1003", "jack" );
		maps.put( "1003", "susan" );






		// 3.获取长度.
		System.out.println( maps.size() );






		// 4.通过key获取value
		Object objValue = maps.get( "1002" );
		System.out.println( objValue.toString() );  // sun





		// 5.获取key部分
		Set      keys = maps.keySet();
		Iterator it   = keys.iterator();
		while ( it.hasNext() ) {

			System.out.println( it.next() );        //1001 1002 1003
		}





		// 6.遍历Map集合
		Set      keys2 = maps.keySet();
		Iterator it2   = keys2.iterator();
		while ( it2.hasNext() ) {

			Object okey   = it2.next();

			Object ovalue = maps.get( okey );

			System.out.println( okey + ":" + ovalue );
		}

	}

}
