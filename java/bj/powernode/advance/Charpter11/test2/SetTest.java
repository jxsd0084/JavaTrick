package bj.powernode.advance.Charpter11.test2;

import java.util.*;

public class SetTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Set< String > set = new HashSet< String >();

		// s1 = "Hello2";
		// s1 = "Hello3";
		// s1 = "Hello4";
		// s1 = "Hello5";
		// s1 = "Hello6";

		// Set里面装的是对象的引用
		// set里面的数据是不可重复的 ? 是引用不能重复呢 ? 还是引用所执行的对象的内容不能重复呢 ?

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






		Set< Integer > set2 = new HashSet< Integer >();

		set2.add( 1 );
		set2.add( 2 );
		set2.add( 3 );
		set2.add( 4 );
		set2.add( 2 );

		System.out.println( set2.size() );





		Set< Person > set3 = new HashSet< Person >();
		Person        p1   = new Person( "张1", 21 );
		Person        p2   = new Person( "张2", 22 );
		Person        p3   = new Person( "张3", 23 );
		Person        p4   = new Person( "张4", 24 );
		Person        p5   = new Person( "张1", 21 );

		System.out.println( p1.equals( p5 ) );

		set3.add( p1 );
		set3.add( p2 );
		set3.add( p3 );
		set3.add( p4 );
		set3.add( p5 );

		System.out.println( set3.size() );






		String ss1 = new String( "Hello1" );
		String ss2 = new String( "Hello2" );
		String ss3 = "Hello1";

		Set< String > set4 = new HashSet< String >();
		set.add( ss1 );
		set.add( ss2 );
		set.add( ss3 );

		System.out.println( set.size() );

	}
}
