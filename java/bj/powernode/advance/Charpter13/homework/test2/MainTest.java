package bj.powernode.advance.Charpter13.homework.test2;

import java.util.Set;
import java.util.TreeSet;

public class MainTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Set< Teacher > set = new TreeSet< Teacher >( new TeacherComparator() {

			public int compare( Teacher o1, Teacher o2 ) {

				if ( o1.getAge() < o2.getAge() ) {
					return 1;
				}

				if ( o1.getAge() > o2.getAge() ) {
					return - 1;
				}

				if ( o1.getSalary() < o2.getSalary() ) {
					return 1;
				}

				if ( o1.getSalary() > o2.getSalary() ) {
					return - 1;
				}

				return 0;
			}
		} );


		Teacher t1 = new Teacher( "吴", 45, 5000 );
		Teacher t2 = new Teacher( "王", 45, 6000 );
		Teacher t3 = new Teacher( "李", 44, 4000 );
		Teacher t4 = new Teacher( "曹", 32, 3500 );
		Teacher t5 = new Teacher( "张", 50, 4800 );


		set.add( t1 );
		set.add( t2 );
		set.add( t3 );
		set.add( t4 );
		set.add( t5 );
		set.add( t2 );



		System.out.println( "集合里面元素个数:" + set.size() );



		printSet( set );




	}

	public static void printSet( Set< Teacher > set ) {

		for ( Teacher t : set ) {

			System.out.println( t );
		}

	}

}
