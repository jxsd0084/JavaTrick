package bj.powernode.basic.day10;

public class User {

	// 属性
	private String name;
	private int    age;


	// 构造方法
	/*
	
		构造方法为什么有时候不提供任何参数,有时候提供一个参数，有时候提供两个参数......
		
		构造方法的重载. over load
		
		通过不同的构造方法可以创建不同的对象.
		
		构造方法目的：1.创建对象 2.给属性赋值.
		
		希望在创建某个对象的时候“记录日志”.
	
	*/
	public User() {

	}  // name age属性都采用系统默认的值.

	public User( String name ) {            // name属性赋值,age采用默认.
		this.name = name;
		// 记录日志代码.....
	}

	public User( int age ) {                // age属性赋值,name采用默认.
		this.age = age;
	}

	public User( String name, int age ) {   // name,age属性赋值.
		this.name = name;
		this.age = age;
	}

	/**
	 * 参数
 	 * @param args
	 */
	public static void main( String[] args ) {

		User u1 = new User();
		u1.setName( "sun" );


		User u2 = new User( "张三" );
		User u3 = new User( 50 );
		User u4 = new User( "jack", 20 );
		
		
		/*
		
			静态方法用 "类名." 调用
			实例方法只能用 "对象名." 调用
		
		*/
		
		
		/*
		
			程序分为两个阶段：编译阶段 + 运行阶段
			程序只有在运行的时候才有 “动态的绑定”.
		
		*/

//		u1.eat();


	}


	// 实例方法
	// 随意写:业务怎么实现这个方法就怎么写.
	public boolean eat( String a, String b, String c, int i, int j, int k, String[] strs, Object[] objs ) {

		System.out.println( "XXX在吃东西." );

		System.out.println( this.getName() );   // this是代表调用该方法的对象.

		return false;
	}


	// setter and getter
	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public int getAge() {

		return age;
	}


	public void test( Object obj ) { //Cat

		// obj.eat();       // 编译无法通过.因为Object类型没有eat方法.

		obj.toString();     // 编译能通过.因为Object类有这个toString方法.

		// 运行的时候调用的是Object里的toString方法吗？ 不是.

		// 编译的时候看栈，运行的时候看堆.
	}


}
