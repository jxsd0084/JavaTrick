package bj.mldn.javase02.ch05.no10;

class Person2 {    // 定义Person类

	String name;        // 定义name属性，暂时不封装
	int    age;            // 定义age属性，暂时不封装
	static String country = "A城";    // 定义城市属性，有默认值，static

	public Person2(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public void info() {    // 得到信息
		System.out.println("姓名：" + this.name + "，年龄：" + this.age + "，城市：" + country);
	}
};

public class StaticDemo02 {

	public static void main(String args[]) {

		Person2 p1 = new Person2("张三", 30);     // 实例化对象
		Person2 p2 = new Person2("李四", 31);     // 实例化对象
		Person2 p3 = new Person2("王五", 32);     // 实例化对象
		System.out.println("--------------- 修改之前 -------------");
		p1.info();
		p2.info();
		p3.info();
		p1.country = "B城";        // 修改static属性
		System.out.println("--------------- 修改之后 -------------");
		p1.info();
		p2.info();
		p3.info();
	}
};
