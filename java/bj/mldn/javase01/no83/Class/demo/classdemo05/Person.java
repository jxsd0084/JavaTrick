package bj.mldn.javase01.no83.Class.demo.classdemo05;

interface Info {

	public static final String AUTHOR = "MLDN";

	public String getInfo();

	public String say( String name, String content );

	public void sayHello();
}

public class Person implements Info {

	private String name;
	private int    age;

	public Person() {

	}

	public Person(String name) {

		this.setName(name);
	}

	public Person(String name, int age) {

		this(name);
		this.setAge(age);
	}

	public String getInfo() {

		return "Hello World!!!";
	}

	public String say(String name, String content) {

		return name + "说了：" + content;
	}

	public void sayHello() {

		System.out.println("hello --> " + AUTHOR);
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public int getAge() {

		return age;
	}

	public void setAge(int age) {

		this.age = age;
	}

	public String toString() {

		return "姓名：" + this.name + "；年龄：" + this.age;
	}
}
