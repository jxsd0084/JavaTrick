package bj.mldn.javase02.ch06.no05;

abstract class Person {

	private String name;        // 定义name属性
	private int    age;            // 定义age属性

	public Person(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public void setName(String name) {

		this.name = name;
	}

	public void setAge(int age) {

		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public int getAge() {

		return this.age;
	}

	public abstract String getInfo();    // 抽象方法
}

class Student extends Person {

	private String school;

	public Student(String name, int age, String school) {

		super(name, age);    // 指定要调用抽象类中有两个参数的构造方法
		this.school = school;
	}

	public void setSchool(String school) {

		this.school = school;
	}

	public String getSchool() {

		return this.school;
	}

	public String getInfo() {

		return "姓名：" + super.getName() +
		       "；年龄：" + super.getAge() +
		       "；学校：" + this.getSchool();
	}
}

public class AbstractDemo04 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String args[]) {

		Student stu = new Student("张三", 30, "清华大学");
		System.out.println(stu.getInfo());
	}
}
