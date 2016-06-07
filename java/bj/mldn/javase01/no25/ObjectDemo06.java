package bj.mldn.javase01.no25;

class Person5 {

	private String name;
	private int    age;

	public Person5( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String toString() {    // 覆写了toString()方法

		return "姓名：" + this.name + "，年龄：" + this.age;
	}
}

public class ObjectDemo06 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String arg[] ) {

		System.out.println( new Person5( "张三", 30 ) );
	}

}
