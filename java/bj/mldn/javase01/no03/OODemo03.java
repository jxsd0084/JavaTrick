package bj.mldn.javase01.no03;

class Person3 {

	String name;            // 表示人的姓名
	int    age;             // 表示人的年龄

	public void tell() {    // 定义说话的方法

		System.out.println( "姓名：" + name + "，年龄：" + age );
	}
}

public class OODemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Person3 per = new Person3();    // 产生实例化对象

		per.name = "张三";        // 为名字赋值
		per.age = 30;            // 为年龄赋值

		per.tell();            // 调用方法

	}

}