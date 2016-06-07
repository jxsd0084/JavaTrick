package bj.mldn.javase02.ch13.no03;

import java.util.LinkedList;

public class LinkedListDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		LinkedList< String > link = new LinkedList< String >();
		link.add( "A" );    // 增加元素
		link.add( "B" );    // 增加元素
		link.add( "C" );    // 增加元素
		System.out.println( "初始化链表：" + link );
		link.addFirst( "X" );    // 在开头增加数据
		link.addLast( "Y" );        // 在结尾增加数据
		System.out.println( "增加头和尾之后的链表：" + link );
	}
}
