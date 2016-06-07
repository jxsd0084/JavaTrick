package bj.powernode.advance.Charpter03;

// java从类的层次开始支持面向对象

// 类里面是该类对象所共有的属性和方法
public class Student {


	// 定义类中的属性

	// [修饰符]  类型  变量名称 [=初始值];


	// 面向对象的第一个特点:封装(目的是为了实现信息的隐藏)

	// 1.将属性私有化,但是提供公开的get/set方法
	// 2.方法本身就是一种封装,将方法的声明公开,但是将方法的实现隐藏起来
	// 3.类本身就是一种封装,将属性,方法,构造方法封装在一个类之中

	private int    age  = 20;
	private String name = "张0";

	// 在类的方法中,可以直接使用类中的属性
	// 方法定义的规范: [修饰符] 返回类型  方法名称(参数列表) [throws 异常]{  }
	public void study( String className ) {

		System.out.println( name + " 同学在学习:" + className + " age=" + age );
	}

	public void setName( String _name ) {

		name = _name;
	}

	public String getName() {

		return name;
	}


	// 可以在公开的 get/set 方法中加入业务逻辑判断
	// 避免合法不合理的数据的出现
	// 便于代码的维护
	public void setAge( int _age ) {
	     /*
		 if(_age < 0 || _age > 120 ){
		     System.out.println(_age + " 不是有效的年龄");
			 return;
		 }

		 age = _age;
		 */

		if ( _age < 0 || _age > 120 ) {
			System.out.println( _age + " 不是有效的年龄" );

		} else {
			age = _age;

		}

	}

	public int getAge() {

		return age;
	}

	// 当我们没有提供任何的构造方法的时候,系统会自动的提供一个默认的无参数的构造方法
	// 构造方法的定义规范:[修饰符] 类名(参数列表)[throws 异常]{}
	// 构造方法必须要和类名一样,并且没有任何的返回类型(甚至是void)
	// 当我们自己提供了构造方法之后,默认的无参数的构造方法就不再提供了
	// 如果需要使用,需要自己重新定义!

	// 在一个类中可以同时存在多个构造方法,前提是:构造方法的参数列表必须不同

	// 构造方法重载

	// 什么是参数列表不同?

	// 1.参数的个数不同
	// 2.参数的类型不同
	// 3.参数的顺序不同
	// 4.在参数列表不同的前提下,其他没有限制
	public Student() {

		System.out.println( "无参数的构造方法被调用 name=" + name + " age=" + age );
	}

	private Student( String _name ) {

		name = _name;
		System.out.println( "age参数的构造方法被调用" );
	}

	Student( int _age ) {

		age = _age;
		System.out.println( "age参数的构造方法被调用" );
	}

	public Student( int _age, String _name ) {

		name = _name;
		age = _age;
		System.out.println( "两个参数的构造方法被调用" );
	}

	public Student( String _name, int _age ) {

		System.out.println( "无参数的构造方法被调用 name=" + name + " age=" + age );

		name = _name;
		age = _age;
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		// stu 被称作引用 ,new Student(),会创建一个新的对象
		// 可以通过引用去调用对象上面的属性和方法
		// 构造方法,构造方法专门和new一起使用,用来创建对象的

		Student stu1 = new Student();
		Student stu2 = new Student();
		stu2.age = 23;
		stu2.name = "张三";

		stu2.setName( "张一" );
		stu2.setAge( 21 );
		stu2.study( "CoreJava课程" );




		Student stu3 = new Student( "张二", 22 );
		stu3.age = 23;
		stu3.name = "张三";
		stu3.study( "Oracle课程" );

	}

}
