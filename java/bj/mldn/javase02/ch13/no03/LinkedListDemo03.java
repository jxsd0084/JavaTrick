package bj.mldn.javase02.ch13.no03;

import java.util.LinkedList;

public class LinkedListDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		LinkedList< String > link = new LinkedList< String >();
		link.add( "A" );    // 增加元素
		link.add( "B" );    // 增加元素
		link.add( "C" );    // 增加元素
		System.out.print( "以FIFO的方式输出：" );
		for ( int i = 0; i <= link.size() + 1; i++ ) {
			System.out.print( link.poll() + "、" );
		}
	}
}
