/**
 * 本例主题:初始化块
 */

package bj.powernode.advance.Charpter05.test1;

public class Person {

	private int    age;
	private String name;

	// java代码块,初始化块
	// 初始化块会在调用构造方法之前被自动调用,并且每调用一次构造方法,就会调用一次初始化块
	// 可以在初始化块中放入每次创建对象之前都要完成的工作
	{
		System.out.println( "person类初始化快被调用 name=" + name + " age=" + age );
		age = 21;
		name = "张一";
	}

	public int getAge() {

		return age;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public String getName() {

		return name;
	}

	public void setName( String naem ) {

		this.name = name;
	}

	public Person() {

		System.out.println( "person类无参数的构造方法被调用" );
	}

	public Person( String name, int age ) {

		this.name = name;
		this.age = age;
		System.out.println( "person类两个参数的构造方法被调用" );
	}

}
