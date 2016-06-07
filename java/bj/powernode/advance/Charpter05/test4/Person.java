package bj.powernode.advance.Charpter05.test4;

// 用final修饰一个类,表示该类不能被继承

public /*final*/ class Person {

	// 使用final 修饰符可以修饰属性 方法,类

	// 用final修饰一个属性,表示这是一个常量,必须要显示赋值,并且只能被赋值一次
	// 可以在声明的时候赋值
	public final String sex /* = "女" */;

	// 公开的静态常量
	public static final int MAX_AGE = 150;

	// 可以在代码块中赋值
	{
		// sex = "男";
	}

	// 也可以在构造方法中赋值
	public Person() {

		sex = "男";
	}

	// 被final修饰的方法,表示不能被子类覆盖
	public static final void fun1() {

		System.out.println( "Person类的fun1()方法" );
	}


	// 但是不能在普通方法中赋值
	public void setSex( String sex ) {
		// this.sex = sex;
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Person p = new Person();

		// p.sex = "不男不女";
		int i = Person.MAX_AGE;
	}

}
