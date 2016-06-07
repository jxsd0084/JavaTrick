package bj.powernode.basic.day11;

import java.util.ArrayList;
import java.util.List;


/*

	java.util.List;

		ArrayList

		LinkedList

*/
public class TestList01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		List myList = new ArrayList();

		// 1.添加元素
		myList.add( 1 );  // 自动封箱 1--> Integer i = 1;  编译器的版本在5.0之后,包括5.0

		myList.add( new Integer( 10 ) );

		System.out.println( myList.contains( new Integer( 10 ) ) );  // true...因为java.lang.Integer已经重写了equals和hashCode方法.






		// 2.在指定位置添加元素.
		myList.add( 1, 100 );






		// 3.输出元素的个数
		System.out.println( myList.size() );






		// 4.获取指定索引的元素
		System.out.println( myList.get( 1 ) );






		// 5.添加元素
		myList.add( 100 );





		// 6.输出第一个100的索引
		System.out.println( myList.indexOf( 100 ) );        // 1





		// 7.输出最后一个100的索引
		System.out.println( myList.lastIndexOf( 100 ) );    // 3






		// 8.删除元素(根据索引)
		myList.remove( 1 );

		System.out.println( myList.size() );                // 3







		System.out.println( "=====================" );






		// 9.如何遍历List集合.
		for ( int i = 0; i < myList.size(); i++ ) {

			System.out.println( myList.get( i ) );
		}


	}

}
