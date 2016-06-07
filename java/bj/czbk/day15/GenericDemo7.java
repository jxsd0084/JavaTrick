package bj.czbk.day15;

import java.util.*;

class GenericDemo7 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		TreeSet< Student7 > ts = new TreeSet< Student7 >( new Comp() );

		ts.add( new Student7( "abc03" ) );
		ts.add( new Student7( "abc02" ) );
		ts.add( new Student7( "abc06" ) );
		ts.add( new Student7( "abc01" ) );

		Iterator< Student7 > it = ts.iterator();

		while ( it.hasNext() ) {
			System.out.println( it.next().getName() );
		}


		TreeSet< Worker > ts1 = new TreeSet< Worker >( new Comp() );

		ts1.add( new Worker( "wabc--03" ) );
		ts1.add( new Worker( "wabc--02" ) );
		ts1.add( new Worker( "wabc--06" ) );
		ts1.add( new Worker( "wabc--01" ) );


		Iterator< Worker > it1 = ts1.iterator();

		while ( it1.hasNext() ) {
			System.out.println( it1.next().getName() );
		}
	}
}

/*
class StuComp implements Comparator<Student>
{
	public int compare(Student s1,Student s2)
	{
		return s1.getName().compareTo(s2.getName());
	}
}

class WorkerComp implements Comparator<Worker>
{
	public int compare(Worker s1,Worker s2)
	{
		return s1.getName().compareTo(s2.getName());
	}
}
*/

class Comp implements Comparator< Person > {

	public int compare( Person p1, Person p2 ) {

		return p2.getName().compareTo( p1.getName() );
	}
}


class Person {

	private String name;

	Person( String name ) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	public String toString() {

		return "person :" + name;
	}
}

class Student7 extends Person {

	Student7( String name ) {

		super( name );
	}

}

class Worker extends Person {

	Worker( String name ) {

		super( name );
	}
}
