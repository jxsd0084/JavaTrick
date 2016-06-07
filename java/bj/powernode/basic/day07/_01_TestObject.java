package bj.powernode.basic.day07;

/*

	java.lang.Object类讲解:
	
		两个比较重要的方法: 
			public String toString(){}
			public boolean equals(Object obj){}

	
	toString方法的讲解:
	
		1.SUN公司设计toString方法的作用: 返回该对象的字符串表示
		
			Person p1 = new Person();
			p1.toString(); // p1对象的字符串表示.( 张三 )
			
			Cat c = new Cat();
			c.toString();  //c对象的字符串表示. ( Tom )

	Object中的toString方法的实现: 类名 + @ + 对象内存地址经过哈希算法得出的哈希码的十六进制值.
	
	通常我们说Object的toString方法返回的是“对象的内存地址”.

*/

public class _01_TestObject extends Object {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		
		/*
			Cat c = new Cat();

			String cInfo = c.toString();  //c对象的字符串表示(目前调用的是Object里的toString方法.)

			System.out.println(cInfo);
		*/
		
		/*
			Person p1 = new Person();

			String p1Info = p1.toString();

			System.out.println(p1Info);
		
		*/
		
		/*
			Person p2 = new Person("成龙",50);

			String p2Info = p2.toString();

			System.out.println(p2Info);
		
		*/

		Person p3 = new Person( "巩俐", 50 );

		System.out.println( p3 );               // System.out.println();方法默认调用对象的toString方法.
		System.out.println( p3.toString() );


		System.out.println( "Hello world" );    // 字符串已经重写了toString方法.


		Bird b = new Bird( "麻雀" );

		System.out.println( b.toString() );

	}

}


class Cat extends Object {

	private String name;

	// 重写toString方法
	public String toString() {

		return name;
	}

}


class Person {

	// 属性
	private String name;
	private int    age;


	// 构造方法
	public Person() {

	}

	public Person( String name, int age ) {

		this.name = name;
		this.age = age;
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


	// toString方法的作用:返回该对象的字符串表示.
	// 如何去重写: 随意重写.
	public String toString() {

		return "---->" + name + "今年" + age + "岁";
	}

}


class Bird {

	String name;

	public Bird() {

	}

	public Bird( String name ) {

		this.name = name;
	}

	// public String toString(){
	//	return name;
	// }

}
