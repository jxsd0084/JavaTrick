package bj.powernode.basic.day11;

import java.util.ArrayList;
import java.util.Collection;

public class TestContains {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 1.创建一个集合
		Collection c = new ArrayList();             // 多态.






		// 2.准备元素
		Name name1 = new Name( "jack", "chen" );    // 0x1111
		Name name2 = new Name( "guanxi", "chen" );  // 0x2222
		Name name3 = new Name( "dehua", "liu" );    // 0x3333
		Name name4 = new Name( "jack", "chen" );    // 0x4444





		// 3.添加元素
		c.add( name1 );
		c.add( name2 );
		c.add( name3 );






		// 4.调用contains方法.
		boolean isHave1 = c.contains( name1 );      // true

		System.out.println( isHave1 );

		boolean isHave2 = c.contains( name4 );      // true

		System.out.println( isHave2 );







		// 5.删除对象.
		c.remove( name4 );






		// 6.打印集合的长度
		System.out.println( c.size() );






		// 7.将集合转换成Object数组.
		Object[] objs = c.toArray();
		for ( int i = 0; i < objs.length; i++ ) {

			System.out.println( objs[ i ] );
		}






		// 8.清空集合
		c.clear();





		// 9.输出长度
		System.out.println( c.size() );






	}


}


