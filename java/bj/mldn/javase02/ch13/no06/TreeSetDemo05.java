package bj.mldn.javase02.ch13.no06;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo05 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		SortedSet< String > allSet = new TreeSet< String >();
		allSet.add( "A" );    // 增加内容
		allSet.add( "B" );    // 增加内容
		allSet.add( "C" );    // 增加内容
		allSet.add( "C" );    // 增加内容
		allSet.add( "C" );    // 增加内容
		allSet.add( "D" );    // 增加内容
		allSet.add( "E" );    // 增加内容
		System.out.println( "第一个元素：" + allSet.first() );
		System.out.println( "最后一个元素：" + allSet.last() );
		System.out.println( "headSet元素：" + allSet.headSet( "C" ) );
		System.out.println( "tailSet元素：" + allSet.tailSet( "C" ) );
		System.out.println( "subSet元素：" + allSet.subSet( "B", "D" ) );
	}
}
