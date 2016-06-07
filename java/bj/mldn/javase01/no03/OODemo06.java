package bj.mldn.javase01.no03;

class Person6 {

	String name;    // 表示人的姓名
	int    age;        // 表示人的年龄

	public void tell() {    // 定义说话的方法

		System.out.println( "姓名：" + name + "，年龄：" + age );
	}

}

public class OODemo06 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person6 per1 = null;        // 声明对象
		Person6 per2 = null;        // 声明对象

		per1 = new Person6();       // 实例化对象
		per2 = per1;                // 引用传递

		per1.name = "张三";         // 为名字赋值
		per1.age = 30;              // 为年龄赋值
		per2.age = 33;

		per1.tell();                // 调用方法
		per2.tell();

	}

}
