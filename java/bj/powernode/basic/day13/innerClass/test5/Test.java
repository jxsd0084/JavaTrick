package bj.powernode.basic.day13.innerClass.test5;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		/**
		 * 匿名内部类. 无需关心实现类的类名.
		 * 通常出现在方法的参数列表中：new + 接口名(){}
		 */
		SortedSet< Person > ps = new TreeSet< Person >( new Comparator< Person >() {

			public int compare( Person o1, Person o2 ) {

				if ( o1.getAge() == o2.getAge() ) {
					return 0;

				} else if ( o1.getAge() > o2.getAge() ) {
					return 1;

				} else {
					return -1;

				}
			}

		} );


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
