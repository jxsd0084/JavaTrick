package bj.mldn.javase01.no83.Class.demo.classdemo03;

public class Person {

	private String name;
	private int    age;

	public Person(String name, int age) {

		this.setName(name);
		this.setAge(age);
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

		return "hello world!!!";
	}
}
