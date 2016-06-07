package bj.mldn.javase02.ch13.no07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		List< String > all = new ArrayList< String >();
		all.add( "hello" );
		all.add( "_" );
		all.add( "world" );
		Iterator< String > iter = all.iterator();    // 为Iterator接口实例化
		while ( iter.hasNext() ) {    // 判断是否有内容
			String str = iter.next();
			if ( "_".equals( str ) ) {
				iter.remove();    // 删除元素
			} else {
				System.out.println( str );    // 输出内容
			}
		}
		System.out.println( "删除之后的集合：" + all );
	}
}
