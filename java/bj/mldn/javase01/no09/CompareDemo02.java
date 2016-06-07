package bj.mldn.javase01.no09;

class Person2 {

	private String name;
	private int    age;

	public Person2( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public int getAge() {

		return this.age;
	}
}

public class CompareDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person2 per1 = new Person2( "张三", 30 );
		Person2 per2 = new Person2( "张三", 30 );

		if ( per1.getName().equals( per2.getName() ) && per1.getAge() == per2.getAge() ) {

			System.out.println( "是同一个人！" );
		}

	}

}
