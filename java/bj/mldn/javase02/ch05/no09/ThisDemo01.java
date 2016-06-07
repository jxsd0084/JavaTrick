package bj.mldn.javase02.ch05.no09;

class Person1 {             // 定义Person类

	private String name;    // 姓名
	private int    age;     // 年龄

	public Person1( String name, int age ) {    // 通过构造方法赋值
		name = name;
		age = age;
	}

	public String getInfo() {    // 取得信息的方法
		return "姓名：" + name + "，年龄：" + age;
	}
};

public class ThisDemo01 {

	public static void main( String args[] ) {

		Person1 per1 = new Person1( "张三", 33 );    // 调用构造实例化对象
		System.out.println( per1.getInfo() );       // 取得信息
	}

}
