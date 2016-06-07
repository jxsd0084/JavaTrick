package bj.mldn.javase01.no09;

class Person7 {

	private String name;
	private int    age;

	public Person7() {

		System.out.println( "新的对象产生了。" );
	}

	public Person7( String name ) {

		this.name = name;
		System.out.println( "新的对象产生了。" );
	}

	public Person7( String name, int age ) {

		this.name = name;
		this.age = age;
		System.out.println( "新的对象产生了。" );
	}

	public void setName( String name ) {

		this.name = name;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public int getAge() {

		return this.age;
	}
}

public class ThisDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person7 per = new Person7( "张三", 30 );

		System.out.println( per.getName() + " --> " + per.getAge() );

	}

}
