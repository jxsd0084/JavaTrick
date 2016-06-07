package bj.mldn.javase01.no09;

class Person8 {

	private String name;
	private int    age;

	public Person8() {

		System.out.println( "新的对象产生了。" );
	}

	public Person8( String name ) {

		this();    // 调用无参构造
		this.name = name;
	}

	public Person8( String name, int age ) {

		this( name );    // 调用有一个参数的构造方法
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

public class ThisDemo04 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person8 per = new Person8( "张三", 30 );

		System.out.println( per.getName() + " --> " + per.getAge() );

	}

}
