package bj.powernode.advance.Charpter12.test4;

/**
 * 关键字:
 * list.listIterator();返回此列表元素的列表迭代器（按适当顺序）
 */

import java.util.*;

public class ListTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建List下面的ArrayList集合(数组),泛型String类型
		List< String > list = new ArrayList< String >();

		// 向ArrayList集合中添加元素,注意:是add(),向Map添加元素是put(),要注意区别.
		list.add( "Hello1" );
		list.add( "Hello2" );
		list.add( "Hello4" );
		list.add( "Hello3" );
		list.add( "Hello2" );
		list.add( "Hello1" );
		list.add( 0, "Hello10" );

		// 如果集合中contains(Object o) 如果此列表中包含指定的元素，则返回 true
		if ( list.contains( "Hello4" ) ) {

			// remove(Object o)移除此列表中首次出现的指定元素（如果存在）
			list.remove( "Hello4" );
		}

		System.out.println( "list.size=" + list.size() );

		// 创建Iterator迭代器
		Iterator< String > it = list.iterator();
		// while循环遍历
		while ( it.hasNext() ) {

			// String类型s接收遍历出来的数据
			String s = it.next();
			System.out.println( s );
		}




		System.out.println( "=====================" );




		// set(int index, E element)用指定的元素替代此列表中指定位置上的元素
		list.set( 0, "Hello+++++++++++10" );
		// 增强for循环遍历ArrayList集合
		for ( String s : list ) {

			System.out.println( s );
		}




		System.out.println( "=====================" );





		// for循环遍历集合
		for ( int i = 0; i < list.size(); i++ ) {

			// 用String类型的s接收返回的值,get(int index)返回此列表中指定位置上的元素
			String s = list.get( i );
			System.out.println( s );
		}





		System.out.println( "=====================" );





		// listIterator()返回此列表元素的列表迭代器（按适当顺序）
		ListIterator< String > listIt = list.listIterator();

		// while循环遍历,hasNext()以正向遍历列表时，如果列表迭代器有多个元素，则返回 true
		while ( listIt.hasNext() ) {

			// next()返回列表中的下一个元素
			System.out.println( listIt.next() );
		}





	}

}
