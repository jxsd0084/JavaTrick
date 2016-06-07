package bj.mldn.javase01.no77.Collection.collectiondemo.listdemo;

import java.util.LinkedList;

public class LinkedListDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		LinkedList< String > link = new LinkedList< String >();
		link.add( "A" );
		link.add( "B" );
		link.add( "C" );
		link.addFirst( "X" );
		link.addLast( "Y" );
		for ( int i = 0; i <= link.size(); i++ ) {
			System.out.print( link.element() );    // 取出表头
		}
		System.out.println( "\nelemtn()操作之后：" + link );
		for ( int i = 0; i <= link.size(); i++ ) {
			System.out.print( link.poll() );       // 取出表头，同时删除表头
		}
		System.out.print( "\npoll()操作之后：" + link );
	}

}
