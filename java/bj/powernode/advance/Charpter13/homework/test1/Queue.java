package bj.powernode.advance.Charpter13.homework.test1;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 【程序1】
 * 队列是一种常用的数据结构，它采用“先进先出”的方
 * 式来存储数据，要求写一个类来模拟队列这种数据类
 * 型，要求底层采用List来存储数据，并且让这一类型
 * 实现Iterable接口，使之成为可循环遍历的类。
 */
public class Queue implements Iterable< String > {

	private LinkedList< String > queue = new LinkedList< String >();

	public void push( String s ) {

		queue.addLast( s );
	}

	public String pop() throws QueueException {

		if ( queue.size() > 0 ) {
			return queue.removeFirst();
		} else {
			throw new QueueException( "队列已空" );
		}
	}

	@Override
	public Iterator< String > iterator() {

		return queue.iterator();
	}

}
