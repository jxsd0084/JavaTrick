package bj.mldn.javase01.no77.Collection.execdemo03;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String         name;
	private int            age;
	private List< Course > allCourses;

	public List< Course > getAllCourses() {

		return allCourses;
	}

	public Student() {

		this.allCourses = new ArrayList< Course >();
	}

	public Student( String name, int age ) {

		this();
		this.name = name;
		this.age = age;
	}

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

	public String toString() {

		return "学生姓名：" + this.name + "，学生年龄：" + this.age;
	}
}
