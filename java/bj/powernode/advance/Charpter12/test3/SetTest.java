package bj.powernode.advance.Charpter12.test3;

import java.util.*;

public class SetTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建Set下面的TreeSet集合,String类型的泛型
		Set< String > set = new TreeSet< String >();

		// 向TreeSet集合中添加元素,注意:是add();
		set.add( "aa" );
		set.add( "cc" );
		set.add( "bb" );
		set.add( "ff" );
		set.add( "ee" );
		set.add( "aa" );

		// int size()返回 set 中的元素个数(int类型)（set 的容量）
		System.out.println( set.size() );

		// 创建<Integer>泛型TreeSet集合
		Set< Integer > set1 = new TreeSet< Integer >();

		// 向TreeSet集合中添加元素,注意:是add()
		set1.add( 31 );
		set1.add( 22 );
		set1.add( 4 );
		set1.add( 9 );
		set1.add( 12 );
		set1.add( 5 );
		set1.add( 9 );

		// int size()返回 set 中的元素个数(int类型)（set 的容量）
		System.out.println( set1.size() );

		printSet1( set1 );

		Integer I;

		// TreeSet如何来保证数据的不可重复性?以及来排序?

		// 1.向TreeSet里面添加的数据,要实现Comparable接口的compareTo()方法

		// 如果调用对象的compareTo返回0,不让数据进入到集合中
		// 如果调用对象的compareTo返回1,说明当前对象大于指定对象,将指定对象放在前面
		// 如果调用对象的compareTo返回-1,说明当前对象需奥于指定对象,将指定对象放在后面
		Set< Person > set2 = new TreeSet< Person >();
		Person        p1   = new Person( "aa", 21 );
		Person        p2   = new Person( "cc", 21 );
		Person        p3   = new Person( "ee", 21 );
		Person        p4   = new Person( "ee", 24 );
		Person        p5   = new Person( "dd", 25 );
		Person        p6   = new Person( "aa", 21 );

		set2.add( p1 );
		set2.add( p2 );
		set2.add( p3 );
		set2.add( p4 );
		set2.add( p5 );
		set2.add( p6 );


		System.out.println( "集合里面的数据个数:" + set2.size() );

		printSet2( set2 );


	}

	public static void printSet2( Set< Person > set ) {

		for ( Person s : set ) {

			System.out.println( s );
		}

	}

	public static void printSet1( Set< Integer > set ) {

		for ( Integer s : set ) {

			System.out.println( s );
		}

	}

	public static void printSet( Set< String > set ) {

		for ( String s : set ) {

			System.out.println( s );
		}

	}
}
