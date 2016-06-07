package bj.powernode.basic.day13.innerClass.test4;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Comparator< Person > c = new PersonComparator(); // 准备比较器

		SortedSet< Person > ps = new TreeSet< Person >( c );    // 封装SortedSet集合




		Person p1 = new Person( 10 );
		Person p2 = new Person( 30 );
		Person p3 = new Person( 20 );




		ps.add( p1 );
		ps.add( p2 );
		ps.add( p3 );




		// p1 p3 p2
		for ( Person p : ps ) {

			System.out.println( p );
		}


	}


}
