package bj.mldn.javase01.no09;

class Person3 {

	private String name;
	private int    age;

	public Person3( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public boolean compare( Person3 per ) {

		if ( this == per ) {    // 地址相等
			return true;
		}
		if ( this.name.equals( per.name ) && this.age == per.age ) {
			return true;
		} else {
			return false;
		}
	}

	public String getName() {

		return this.name;
	}

	public int getAge() {

		return this.age;
	}
}

public class CompareDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person3 per1 = new Person3( "张三", 30 );
		Person3 per2 = new Person3( "张三", 30 );

		if ( per1.compare( per1 ) ) {

			System.out.println( "是同一个人！" );
		}

	}

}
