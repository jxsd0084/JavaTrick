package bj.powernode.advance.Charpter10.homework.test5;

public class Person {

	private int    age;
	private String name;

	public Person( int age, String name ) {

		this.age = age;
		this.name = name;
	}

	public Person() {

	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Person p = new Person( 21, "张一" );

		System.out.println( "========" );

	}

}
