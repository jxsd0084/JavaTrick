package bj.powernode.basic.day13.generic;

import java.util.*;

/*

	使用泛型

*/
public class Test02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Set< String > strs = new HashSet< String >();  // 在编译阶段,限定集合中存储的元素类型,使类型更加统一.

		// strs.add(1);  //编译无法通过.

		strs.add( "hello" );
		strs.add( new String( "world" ) );

		// 遍历
		Iterator< String > it = strs.iterator();
		while ( it.hasNext() ) {

			String s = it.next();  // 无需强制类型转换.

			System.out.println( s );
		}


		Set< Student > stus = new HashSet< Student >();

		Student s1 = new Student( "jack" );
		Student s2 = new Student( "sun" );
		Student s3 = new Student( "lucy" );

		stus.add( s1 );
		stus.add( s2 );
		stus.add( s3 );


		Iterator< Student > it2 = stus.iterator();
		while ( it2.hasNext() ) {

			Student s = it2.next();

			System.out.println( s );
		}


	}

}


class Student {

	private String name;

	public Student() {

	}

	public Student( String name ) {

		this.name = name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	public boolean equals( Object obj ) {

		if ( this == obj ) {

			return true;
		}

		if ( obj == null ) {

			return false;
		}

		if ( obj instanceof Student ) {

			Student s = (Student) obj;

			if ( s.name.equals( this.name ) ) {

				return true;
			}
		}

		return false;
	}

	public int hashCode() {

		return name.hashCode();
	}

	public String toString() {

		return name;
	}

}
