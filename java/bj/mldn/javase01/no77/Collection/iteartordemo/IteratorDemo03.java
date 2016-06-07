package bj.mldn.javase01.no77.Collection.iteartordemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo03 {

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
		Iterator< String > iter = allList.iterator();
		while ( iter.hasNext() ) {
			String str = iter.next(); // 取出内容
			if ( "C".equals( str ) ) {
				allList.remove( str );  // 删除元素，使用的是List接口的删除
			}
			System.out.print( str + "、" );
		}
		System.out.println( "\n删除之后的集合：" + allList );
	}
}
