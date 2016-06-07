package bj.powernode.advance.Charpter13.homework.test2;

import java.util.*;

public class Main {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Set< Teacher > set = new TreeSet< Teacher >( new TeacherComparator() );



		Teacher        t1  = new Teacher( "吴", 37, 5000 );
		Teacher        t2  = new Teacher( "王", 45, 6000 );
		Teacher        t3  = new Teacher( "王", 45, 6000 );
		Teacher        t4  = new Teacher( "曹", 45, 3500 );
		Teacher        t5  = new Teacher( "张", 50, 4800 );




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

	// public static void main(String[] args) {
	// Set<Teacher> set = new HashSet<Teacher>();
	// Teacher t1 = new Teacher("吴", 45, 5000);
	// Teacher t2 = new Teacher("王", 45, 6000);
	// Teacher t3 = new Teacher("李", 44, 4000);
	// Teacher t4 = new Teacher("曹", 32, 3500);
	// Teacher t5 = new Teacher("张", 50, 4800);
	//
	// set.add(t1);
	// set.add(t2);
	// set.add(t3);
	// set.add(t4);
	// set.add(t5);
	// set.add(t2);
	// System.out.println("集合里面元素个数:" + set.size());
	// printSet(set);
	// }
	//
	// public static void printSet(Set<Teacher> set) {
	// for (Teacher t : set) {
	// System.out.println(t);
	// }
	// }
}
