package bj.mldn.javase01.no77.Collection.listiteartordemo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		List< String > allList = new ArrayList< String >();
		allList.add( "A" );
		allList.add( "B" );
		allList.add( "C" );
		allList.add( "D" );
		allList.add( "E" );
		ListIterator< String > iter = allList.listIterator();
		System.out.print( "从前向后输出：" );
		while ( iter.hasNext() ) {
			System.out.print( iter.next() + "、" );
		}
		System.out.print( "\n从后向前输出：" );
		while ( iter.hasPrevious() ) {
			System.out.print( iter.previous() + "、" );
		}
	}

}
