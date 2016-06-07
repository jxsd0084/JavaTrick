package bj.mldn.javase01.no22;

abstract class Person {

	private String name;
	private int    age;

	public Person(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public int getAge() {

		return this.age;
	}

	public void say() {

		System.out.println(this.getContent());
	}

	public abstract String getContent();
}

class Student extends Person {

	private float score;

	public Student(String name, int age, float score) {

		super(name, age);
		this.score = score;
	}

	public String getContent() {

		return "学生说 --> 姓名：" + super.getName()
		       + "；年龄：" + super.getName()
		       + "；成绩：" + this.score;
	}
}

class Worker extends Person {

	private float salary;

	public Worker(String name, int age, float salary) {

		super(name, age);
		this.salary = salary;
	}

	public String getContent() {

		return "工人说 --> 姓名：" + super.getName()
		       + "；年龄：" + super.getName()
		       + "；工资：" + this.salary;
	}
}

public class AbstPolDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String args[]) {

		Person per1 = new Student("张三", 20, 89.0f);
		Person per2 = new Worker("李四", 30, 1189.0f);

		per1.say();
		per2.say();

	}

}
