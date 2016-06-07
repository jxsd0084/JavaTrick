package bj.mldn.javase01.no04;

class Person {

	String name;            // 表示人的姓名
	int    age;             // 表示人的年龄

	public void tell() {    // 定义说话的方法

		System.out.println( "姓名：" + name + "，年龄：" + age );
	}

}

public class OODemo08 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		Person per = new Person();   // 实例化对象

		per.name = "张三";            // 为name属性赋值
		per.age = - 30;

		per.tell();

	}

}
