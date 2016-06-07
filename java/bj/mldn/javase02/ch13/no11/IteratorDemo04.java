package bj.mldn.javase02.ch13.no11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IteratorDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Map< String, String > map = null;                      // 声明Map对象，其中key和value的类型为String
		map = new HashMap< String, String >();
		map.put( "mldn", "www.mldn.cn" );                      // 增加内容
		map.put( "zhinangtuan", "www.zhinangtuan.net.cn" );    // 增加内容
		map.put( "mldnjava", "www.mldnjava.cn" );              // 增加内容
		Set< Map.Entry< String, String > > allSet = null;
		allSet = map.entrySet();
		Iterator< Map.Entry< String, String > > iter = null;
		iter = allSet.iterator();
		while ( iter.hasNext() ) {
			Map.Entry< String, String > me = iter.next();
			System.out.println( me.getKey() + " --> " + me.getValue() );
		}
	}
}
