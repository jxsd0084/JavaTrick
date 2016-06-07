package bj.powernode.advance.Charpter12.test7;
/**
 * 关键字:
 * map.get(key);
 */

import java.util.*;

public class TreeMapTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// TreeMap能够按照key来进行排序;创建Map下面的TreeMap集合(多态);匿名内部类方式
		Map< Integer, String > map = new TreeMap< Integer, String >(
			new Comparator< Integer >() {

				// 重写compare方法
				public int compare( Integer o1, Integer o2 ) {

					if ( o1.intValue() > o2.intValue() ) {

						return - 1;
					}

					if ( o1.intValue() < o2.intValue() ) {

						return 1;
					}

					return 0;
				}
			} );

		// 将元素添加进TreeMap集合中,注意:此处用的是put()方法
		map.put( 2, "Hello2" );
		map.put( 24, "Hello24" );
		map.put( 10, "Hello10" );
		map.put( 1, "Hello2" );
		map.put( 9, "Hello10" );

		// keySet() 返回此映射包含的键的 Set 视图,用Integer类型的keys接收
		Set< Integer > keys = map.keySet();

		// 增强for循环遍历keys
		for ( Integer key : keys ) {

			// 用String类型的value接收get()
			String value = map.get( key );

			// 输出得到的值
			System.out.println( "key= " + key + "   value" + value );
		}

	}

}
