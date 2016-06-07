package bj.mldn.javase01.no03;

class Person2 {

	String name;            // 表示人的姓名
	int    age;             // 表示人的年龄

	public void tell() {    // 定义说话的方法

		System.out.println( "姓名：" + name + "，年龄：" + age );
	}
}

public class OODemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		Person2 per = new Person2();    // 产生实例化对象

	}

}
