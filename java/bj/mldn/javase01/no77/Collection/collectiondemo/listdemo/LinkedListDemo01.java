package bj.mldn.javase01.no77.Collection.collectiondemo.listdemo;

import java.util.LinkedList;

public class LinkedListDemo01 {

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
		System.out.println( "链表头：" + link.getFirst() );
		System.out.println( "链表尾：" + link.getLast() );
	}

}
