package bj.mldn.javase02.ch05.no10;

class Person1 {    // 定义Person类

	String name;        // 定义name属性，暂时不封装
	int    age;            // 定义age属性，暂时不封装
	String country = "A城";    // 定义城市属性，有默认值

	public Person1(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public void info() {    // 得到信息
		System.out.println("姓名：" + this.name + "，年龄：" + this.age + "，城市：" + country);
	}
};

public class StaticDemo01 {

	public static void main(String args[]) {

		Person1 p1 = new Person1("张三", 30);     // 实例化对象
		Person1 p2 = new Person1("李四", 31);     // 实例化对象
		Person1 p3 = new Person1("王五", 32);     // 实例化对象

		p1.info();
		p2.info();
		p3.info();
	}
};
