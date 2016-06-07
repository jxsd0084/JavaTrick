package bj.mldn.javase02.ch20.no04;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

public class GetAllCharsetDemo {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		SortedMap< String, Charset > all = null;
		all = Charset.availableCharsets();    // 得到全部可用的字符集
		Iterator< Map.Entry< String, Charset > > iter = null;
		iter = all.entrySet().iterator();
		while ( iter.hasNext() ) {
			Map.Entry< String, Charset > me = iter.next();
			System.out.println( me.getKey() + " --> " + me.getValue() );
		}
	}
}
