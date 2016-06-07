package bj.mldn.javase01.no09;

class Person5 {

	private String name;
	private int    age;

	public Person5( String name, int age ) {

		name = name;
		age = age;
	}

	public void setName( String n ) {

		name = n;
	}

	public void setAge( int a ) {

		age = a;
	}

	public String getName() {

		return name;
	}

	public int getAge() {

		return age;
	}
}

public class ThisDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person5 per = new Person5( "张三", 30 );

		System.out.println( per.getName() + " --> " + per.getAge() );

	}

}
