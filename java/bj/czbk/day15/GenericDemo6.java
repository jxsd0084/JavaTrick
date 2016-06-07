package bj.czbk.day15;

import java.util.*;


/*

? 通配符。也可以理解为占位符。

泛型的限定；
？ extends E : 可以接收E类型或者E的子类型。上限。
？ super E   : 可以接收E类型或者E的父类型。下限

*/


class GenericDemo6 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		/*
		ArrayList<String> al = new ArrayList<String>();

		al.add("abc1");
		al.add("abc2");
		al.add("abc3");

		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(4);
		al1.add(7);
		al1.add(1);

		printColl(al);
		printColl(al1);
		*/

		ArrayList< Person6 > al = new ArrayList< Person6 >();
		al.add( new Person6( "abc1" ) );
		al.add( new Person6( "abc2" ) );
		al.add( new Person6( "abc3" ) );
		//printColl(al);

		ArrayList< Student6 > al1 = new ArrayList< Student6 >();
		al1.add( new Student6( "abc--1" ) );
		al1.add( new Student6( "abc--2" ) );
		al1.add( new Student6( "abc--3" ) );
		printColl( al1 );  //ArrayList<? extends Person> al = new ArrayList<Student>();error

	}

	public static void printColl( Collection< ? extends Person6 > al ) {

		Iterator< ? extends Person6 > it = al.iterator();


		while ( it.hasNext() ) {
			System.out.println( it.next().getName() );
		}
	}
	/*
	public static void printColl(ArrayList<?> al)//ArrayList al = new ArrayList<Integer>();error
	{
		Iterator<?> it = al.iterator();


		while(it.hasNext())
		{
			System.out.println(it.next().toString());
		}
	}
	*/
}

class Person6 {

	private String name;

	Person6( String name ) {

		this.name = name;
	}

	public String getName() {

		return name;
	}
}

class Student6 extends Person6 {

	Student6( String name ) {

		super( name );
	}

}


/*
class Student implements Comparable<Person>//<? super E>
{
	public int compareTo(Person s)
	{
		this.getName()
	}
}
*/

class Comp6 implements Comparator< Person6 > {

	public int compare( Person6 s1, Person6 s2 ) {

		//Person s1 = new Student("abc1");
		return s1.getName().compareTo( s2.getName() );
	}
}

/*
	TreeSet<Student> ts = new TreeSet<Student>(new Comp());
	ts.add(new Student("abc1"));
	ts.add(new Student("abc2"));
	ts.add(new Student("abc3"));
*/

