package bj.powernode.advance.Charpter12.test1;

import java.util.*;

public class SetTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Set< String > set = new HashSet< String >();

		String s2 = "Hello2";
		String s3 = "Hello3";
		String s4 = "Hello4";
		String s5 = "Hello5";
		String s6 = "Hello6";

		// Set里面装的是对象的引用
		// set里面的数据是不可重复的? 是引用不能重复呢?还是引用所执行的对象的内容不能重复呢?

		String s1 = "Hello1";
		set.add( s1 );

		s1 = "Hello2";
		set.add( s1 );

		s1 = "Hello3";
		set.add( s1 );

		s1 = "Hello4";
		set.add( s1 );

		s1 = "Hello5";
		set.add( s1 );

		s1 = "Hello6";
		set.add( s1 );

		System.out.println( set.size() );






		Set< Integer > set1 = new HashSet< Integer >();

		set1.add( 1 );
		set1.add( 2 );
		set1.add( 3 );
		set1.add( 4 );
		set1.add( 2 );

		System.out.println( set1.size() );





		// 把多个对象要添加到HashSet里面,要求对象不能重复
		// 如何来判读对象不能重复,要求覆盖对象上的hashCode()和equals()方法

		Set< Person > set2 = new HashSet< Person >();
		Person        p1   = new Person( "张1", 21 );
		Person        p2   = new Person( "张2", 22 );
		Person        p3   = new Person( "张3", 23 );
		Person        p4   = new Person( "张4", 24 );
		Person        p5   = new Person( "张5", 25 );
		Person        p6   = new Person( "张6", 21 );
		Person        p7   = new Person( "张7", 22 );
		Person        p8   = new Person( "张8", 23 );
		Person        p9   = new Person( "张9", 24 );
		Person        p10  = new Person( "张10", 25 );
		Person        p11  = new Person( "张11", 21 );
		Person        p12  = new Person( "张12", 22 );
		Person        p13  = new Person( "张13", 23 );

		set2.add( p1 );
		set2.add( p2 );
		set2.add( p3 );
		set2.add( p4 );
		set2.add( p5 );
		set2.add( p6 );
		set2.add( p7 );
		set2.add( p8 );
		set2.add( p9 );
		set2.add( p10 );
		set2.add( p11 );
		set2.add( p12 );
		set2.add( p13 );


		System.out.println( set2.size() );






		Iterator< Person > it = set2.iterator();
		while ( it.hasNext() ) {

			Person p = it.next();
			System.out.println( p );
		}

		for ( Person p : set2 ) {

			System.out.println( p );
		}

	}

}
