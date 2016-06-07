package bj.powernode.advance.Charpter12.test6;

import java.util.*;

public class MapTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建Map下面的 HashMap集合
		Map< String, Integer > map = new HashMap< String, Integer >();

		// 向HashMap中添加元素
		map.put( "Hello1", 100 );
		map.put( "Hello2", 200 );
		map.put( "Hello3", 10 );
		map.put( "Hello4", 10 );
		map.put( "Hello1", 400 );

		// entrySet() 返回此映射中包含的映射关系的 Set 视图,注意:此处的创建方式
		Set< Map.Entry< String, Integer > > set = map.entrySet();





		// 第一种遍历方式:Iterator遍历
		// 创建Iterator对象
		Iterator< Map.Entry< String, Integer > > it = set.iterator();
		// while循环遍历
		while ( it.hasNext() ) {
			Map.Entry< String, Integer > entry = it.next();
			String                       key   = entry.getKey();
			Integer                      value = entry.getValue();
			System.out.println( "key=" + key + " value-" + value );
		}






		// 第二种遍历方式:增强for循环遍历
		for ( Map.Entry< String, Integer > entry : set ) {
			String  key   = entry.getKey();
			Integer value = entry.getValue();
			System.out.println( "key=" + key + " value-" + value );
		}





		// 循环遍历key
		Set< String >      set2 = map.keySet();
		Iterator< String > it2  = set2.iterator();
		while ( it2.hasNext() ) {
			String  key   = it2.next();
			Integer value = map.get( key );
			System.out.println( "key=" + key + " value=" + value );
		}

		System.out.println( "Map里面的数据对数是:" + map.size() );





		// containsKey(Object key) 如果此映射包含指定键的映射关系，则返回 true
		if ( map.containsKey( "Hello2" ) ) {
			// remove(Object key) 如果此 TreeMap 中存在该键的映射关系，则将其删除
			Integer I = map.remove( "Hello2" );
			System.out.println( I );
		}
		// size()返回此映射中的键-值映射关系数
		System.out.println( "Map里面的数据对数是:" + map.size() );





	}

}
