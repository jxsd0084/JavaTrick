package bj.mldn.javase02.ch13.no08;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String argsp[] ) {

		List< String > all = new ArrayList< String >();
		all.add( "hello" );
		all.add( "_" );
		all.add( "world" );
		ListIterator< String > iter = all.listIterator();
		System.out.print( "由前向后输出：" );
		while ( iter.hasNext() ) {
			String str = iter.next();
			System.out.print( str + "、" );
		}
		System.out.print( "\n由后向前输出：" );
		while ( iter.hasPrevious() ) {
			String str = iter.previous();
			System.out.print( str + "、" );
		}
	}
}
