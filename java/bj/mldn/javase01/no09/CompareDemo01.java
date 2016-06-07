package bj.mldn.javase01.no09;

class Person1 {

	private String name;
	private int    age;

	public Person1( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public void fun( Person1 temp ) {

		temp.name = "李四";
		temp.age = 33;
	}

	public String getName() {

		return this.name;
	}

	public int getAge() {

		return this.age;
	}
}

public class CompareDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person1 per = new Person1( "张三", 30 );

		per.fun( per );

		System.out.println( per.getName() + " --> " + per.getAge() );

	}

}
