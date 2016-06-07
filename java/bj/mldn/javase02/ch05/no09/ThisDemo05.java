package bj.mldn.javase02.ch05.no09;

class Person5 {        // 定义Person类

	private String name;    // 姓名
	private int    age;     // 年龄

	public Person5() {      // 无参构造
		this( "LXH", 30 );  // 调用有两个参数的构造方法
		System.out.println( "新对象实例化" );
	}

	public Person5( String name ) {

//		this(); // 调用本类中的无参构造方法
		this.name = name;
	}

	public Person5( String name, int age ) {    // 通过构造方法赋值
		this( name );         // 调用有一个参数的构造方法
		this.age = age;       // 为类中的age属性赋值
	}

	public String getInfo() {    // 取得信息的方法
		return "姓名：" + name + "，年龄：" + age;
	}
};

public class ThisDemo05 {

	public static void main( String args[] ) {

		Person5 per1 = new Person5( "张三", 33 );   // 调用构造实例化对象
		System.out.println( per1.getInfo() );       // 取得信息
	}

}
