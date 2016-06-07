package bj.czbk.day15;

import java.util.*;

class GenericTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		/*
		ArrayList al = new	ArrayList();
		al.add(new Person("heihei"));

		ArrayList al1 = new ArrayList();

		al1.add("haha1");
		al1.add("haha2");

		al.addAll(al1);

		System.out.println(al);int.next().getName();
		*/

		/**/

		ArrayList< Person8 > al = new ArrayList< Person8 >();
		al.add( new Person8( "ahah" ) );

		ArrayList< Student8 > al1 = new ArrayList< Student8 >();

		al1.add( new Student8( "haha" ) );

		al.addAll( al1 );


		Iterator< Person8 > it = al.iterator();

		while ( it.hasNext() ) {
			System.out.println( it.next().getName() );
		}


	}
}

class Person8 {

	private String name;

	Person8( String name ) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	public String toString() {

		return "person :" + name;
	}
}

class Student8 extends Person8 {

	Student8( String name ) {

		super( name );
	}

}

/*
	Person p = new PErson();
	p.equals("haha");
	Demo d = new Demo();
	d.equals(p);
*/

// 泛型搞定：泛型的使用。对于集合类中的泛型会用即可。可以看得懂上限下限，泛型类和泛型方法定义。

