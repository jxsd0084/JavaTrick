package bj.mldn.javase01.no77.Collection.iteartordemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo02 {

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
				iter.remove();        // 删除元素
			}
			System.out.print( str + "、" );
		}
		System.out.println( "删除之后的集合：" + allList );
	}
}
