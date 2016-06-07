package bj.powernode.advance.Charpter12.test2;

import java.util.*;

public class SetTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 也可以使用匿名内部类来实现Comparator接口
		Set< Person > set = new TreeSet< Person >( new Comparator< Person >() {

			// 根据第一个参数小于、等于或大于第二个参数分别返回负整数、零或正整数
			public int compare( Person o1, Person o2 ) {

				if ( o1.getAge() < o2.getAge() ) {

					return - 1;
				}

				if ( o1.getAge() > o2.getAge() ) {

					return 1;
				}

				if ( o1.getName().compareTo( o2.getName() ) > 0 ) {

					return 1;
				}

				if ( o1.getName().compareTo( o2.getName() ) < 0 ) {

					return - 1;
				}

				return 0;
			}

		} );

		Person p1 = new Person( "aa", 21 );
		Person p2 = new Person( "cc", 21 );
		Person p3 = new Person( "ee", 21 );
		Person p4 = new Person( "ee", 24 );
		Person p5 = new Person( "dd", 25 );
		Person p6 = new Person( "aa", 21 );

		set.add( p1 );
		set.add( p2 );
		set.add( p3 );
		set.add( p4 );
		set.add( p5 );
		set.add( p6 );


		System.out.println( "集合里面的数据个数:" + set.size() );

		printSet2( set );



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
