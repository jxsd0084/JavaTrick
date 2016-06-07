package bj.mldn.javase02.ch05.no02;

class Person3 {

	String name;        // 声明姓名属性
	int    age;            // 声明年龄属性

	public void tell() {    // 取得信息
		System.out.println("姓名：" + name + "，年龄：" + age);
	}
}

public class ClassDemo04 {

	public static void main(String args[]) {

		Person3 per1 = null;        // 声明per1对象
		Person3 per2 = null;        // 声明per2对象
		per1 = new Person3();       // 实例化per1对象
		per2 = new Person3();       // 实例化per2对象
		per1.name = "张三";         // 设置per1中的name属性内容
		per1.age = 30;              // 设置per1中的age属性内容
		per2.name = "李四";         // 设置per2中的name属性内容
		per2.age = 33;              // 设置per2中的age属性内容
		System.out.print("per1对象中的内容 --> ");
		per1.tell();                // 调用类中的方法
		System.out.print("per2对象中的内容 --> ");
		per2.tell();                // 调用类中的方法
	}
};
