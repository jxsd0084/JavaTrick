package bj.mldn.javase02.ch05.no10;

class Person3 {    // 定义Person类

	String name;        // 定义name属性，暂时不封装
	int    age;            // 定义age属性，暂时不封装
	static String country = "A城";    // 定义城市属性，有默认值，static

	public Person3(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public void info() {    // 得到信息
		System.out.println("姓名：" + this.name + "，年龄：" + this.age + "，城市：" + country);
	}
};

public class StaticDemo03 {

	public static void main(String args[]) {

		Person3 p1 = new Person3("张三", 30);     // 实例化对象
		Person3 p2 = new Person3("李四", 31);     // 实例化对象
		Person3 p3 = new Person3("王五", 32);     // 实例化对象
		System.out.println("--------------- 修改之前 -------------");
		p1.info();
		p2.info();
		p3.info();
		Person3.country = "B城";
		System.out.println("--------------- 修改之后 -------------");
		p1.info();
		p2.info();
		p3.info();
	}
};
