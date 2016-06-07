package bj.mldn.javase02.ch06.no11;

class Person {

	private String name;    // 定义name属性
	private int    age;        // 定义age属性

	public Person(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public String toString() {

		return "姓名：" + this.name + "；年龄：" + this.age;
	}
}

public class ObjectDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String args[]) {

		Person per = new Person("李兴华", 30);     // 实例化Person
		System.out.println("对象信息：" + per);
	}
}
