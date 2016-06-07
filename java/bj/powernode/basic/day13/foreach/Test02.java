package bj.powernode.basic.day13.foreach;

import java.util.*;

public class Test02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		List< Student > stus = new ArrayList< Student >();

		Student s1 = new Student( "AAA" );
		Student s2 = new Student( "BBB" );
		Student s3 = new Student( "CCC" );
		Student s4 = new Student( "DDD" );

		stus.add( s1 );
		stus.add( s2 );
		stus.add( s3 );
		stus.add( s4 );


		// 传统的遍历
		Iterator< Student > it1 = stus.iterator();
		while ( it1.hasNext() ) {

			Student s = it1.next();

			System.out.println( s );
		}




		System.out.println( "=====================================" );



		// foreach
		/*
			foreach缺陷：
				1.没有下标.
				2. it.remove(); 没有这个功能.
		
		*/
		for ( Student s : stus ) {

			System.out.println( s );
		}


		Map< Integer, String > maps = new HashMap< Integer, String >();


		maps.put( 1, "AAA" );
		maps.put( 2, "BBB" );
		maps.put( 3, "CCC" );
		maps.put( 4, "DDD" );




		System.out.println( "=====================================" );





		// 遍历
		Set< Integer > keys = maps.keySet();
		for ( Integer i : keys ) {  //i 是key

			String value = maps.get( i );

			System.out.println( i + "--->" + value );
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
