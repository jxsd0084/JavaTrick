package bj.powernode.basic.day06.TestSuper;


//  子类Cat
public class Cat extends Animal {

	public Cat() {

		//  System.out.println("Cat will created.");    //  对 super 的调用必须是构造函数中的第一个语句

		//  创建子类对象的时候先创建父类对象,所以在这个地方有一个super();
		super();
	}

	//  有参数构造
	public Cat( String name, int age ) {

		//  super()和this()都必须出现在构造方法的第一行,所以这两个方法不能共存.
		super( name, age );

		//  this();

	}

	//  每个构造方法中都有super()这句话正确吗？不正确.

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		Cat c = new Cat();

		Cat c2 = new Cat( "tom", 3 );

		//  o1 和 o2的内存地址不同,指向的对象不是同一个对象.
		//  new关键字生成的对象肯定在堆空间中开辟一块新的空间。
		Object o1 = new Object();
		Object o2 = new Object();

	}

}
