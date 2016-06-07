package bj.powernode.advance.Charpter05.test5;

// abstract可以修饰一个类,方法

// 用abstract修饰一个类,表示这是一个抽象类,抽象类和具体类唯一的区别就是不能直接实例化

// 抽象类中可以定义抽象方法,抽象类就是用来被继承的

// 抽象类可以有抽象方法,也可以有实例方法,也可以有实例属性

// 抽象类中也可以所有的方法都是已实现的方法

// 如果一个类中有抽象方法,则这个类一定要声明为抽象类

public abstract class Car extends Object {

	private String name;

	// setter and getter
	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	// 无参构造方法
	public Car() {

		System.out.println( "Car类的构造方法被调用" );
	}

	// 一个参数的构造方法
	public Car( String name ) {

		this.name = name;
		System.out.println( "QQ类的构造方法被调用" );
	}

	// 用abstract修饰一个方法,表示这是一个抽象的方法,只有声明,没有实现
	public abstract void run();

	public abstract void stop();

}
