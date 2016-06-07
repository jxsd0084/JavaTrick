package bj.powernode.basic.day06.TestSuper;


// 父类Animal
public class Animal extends Object {

	private String name;
	private int    age;


	// 无参构造
	public Animal() {

		super();  // 调用java.lang.Object这个类的无参构造.
	}

	// 有参数构造方法定义之后,无参数构造方法将被覆盖.
	public Animal( String name, int age ) {

		super();
		this.name = name;
		this.age = age;
	}

}

//  如果一个构造方法第一行不是this(XXXXX),那么肯定是super();
