package bj.mldn.javase01.no09;

class Person6 {

	private String name;
	private int    age;

	public Person6( String name, int age ) {

		this.name = name;
		this.age = age;
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

public class ThisDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person6 per = new Person6( "张三", 30 );

		System.out.println( per.getName() + " --> " + per.getAge() );

	}

}
