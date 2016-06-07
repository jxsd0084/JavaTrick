package bj.mldn.javase01.no69.persondemo;

import java.io.Serializable;

public class Person implements Serializable {

	private String name;

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public int getAge() {

		return age;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	private int age;

	public Person( String name, int age ) {

		this.name = name;
		this.age = age;
	}

	public String toString() {

		return "姓名：" + this.name + "，年龄：" + this.age;
	}
}
