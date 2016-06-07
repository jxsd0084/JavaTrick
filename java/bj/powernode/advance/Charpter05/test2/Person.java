/**
 * 本例主题:静态初始化块
 * 关键字:
 * static{}
 */

package bj.powernode.advance.Charpter05.test2;

public class Person {

	// 没有被static修饰的属性,也可以叫做实例属性,是每个实例都有的属性
	private int    age  = 21;
	private String name = "张一";

	{
		System.out.println( "person的初始化块被调用" );
	}

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public int getAge() {

		return age;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public static void fun1() {

		System.out.println( "父类的fun1()方法" );
	}

	public Person() {

		super();
		System.out.println( "person的无参数的构造方法被调用" );
	}

	public Person( int age, String name ) {

		super();
		this.age = age;
		this.name = name;
		System.out.println( "person的两个参数的构造方法被调用" );
	}

	public String toString() {

		return "person的信息:name=" + name + " age=" + age + " maxAge="
		       + Person.maxAge;
	}

	// ----------------------------------------------

	// static 修饰符
	// 可以修饰一个属性,该属性称为类属性
	// 加static修饰的属性,在内存中只有一份,被该类所有的对象所共享
	// 如果一个类所有的对象的某个属性都相同,则该属性应该加上static修饰符
	static int maxAge = 120;

	// 可以修饰一个代码块,该属性称为静态初始化快
	static {

		System.out.println( "person的静态出师快块被调用 : maxAge=" + maxAge );
	}

	// 可以修饰一个方法,该属性称为类类
	public static void setMaxAge( int maxAge ) {

//		this.name = "";
		Person.maxAge = maxAge;
	}

	public static int getMaxAge() {

		return maxAge;
	}

	// ----------------------------------------------

}
