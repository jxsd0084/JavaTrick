package bj.powernode.basic.day13.collections;

import java.util.*;

/*

	Collection 和 Collections 的区别.

	java.util.Collection 是 集合接口.

	java.util.Collections是 集合工具类,提供了很多静态方法,来完成对集合的操作.

*/
public class TestCollections {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		List< Person > ps = new ArrayList< Person >();

		Person p1 = new Person( 10 );
		Person p2 = new Person( 40 );
		Person p3 = new Person( 30 );
		Person p4 = new Person( 50 );
		Person p5 = new Person( 18 );


		ps.add( p1 );
		ps.add( p2 );
		ps.add( p3 );
		ps.add( p4 );
		ps.add( p5 );

		Collections.sort( ps );

		for ( Person p : ps ) {

			System.out.println( p );
		}


		// 使用二分法查找 年龄是30的这个人所在的下标.
		int index = Collections.binarySearch( ps, p3 );

		System.out.println( index ); // 2

	}
}


class Person implements Comparable< Person > {

	private int age;

	public Person() {

	}

	public Person( int age ) {

		this.age = age;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public int getAge() {

		return age;
	}

	public boolean equals( Object obj ) {

		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( obj instanceof Person ) {
			Person p = (Person) obj;
			if ( p.age == this.age ) {
				return true;
			}
		}
		return false;
	}

	public String toString() {

		return "年龄--->" + age;
	}

	public int hashCode() {

		return age + 132;
	}


	public int compareTo( Person p ) {

		if ( this.getAge() == p.getAge() ) {

			return 0;
		}

		if ( this.getAge() > p.getAge() ) {

			return 1;
		} else {

			return -1;
		}
	}

}
