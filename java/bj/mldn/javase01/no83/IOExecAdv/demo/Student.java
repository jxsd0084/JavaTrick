package bj.mldn.javase01.no83.IOExecAdv.demo;

import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {

	private int    stuno;
	private String name;
	private int    count;

	public Student() {

		super();
	}

	public Student(int stuno, String name, int count) {

		super();
		this.stuno = stuno;
		this.name = name;
		this.count = count;
	}

	public int getStuno() {

		return stuno;
	}

	public void setStuno(int stuno) {

		this.stuno = stuno;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public int getCount() {

		return count;
	}

	public void setCount(int count) {

		this.count = count;
	}

	public int compareTo(Student stu) {

		if (this.count > stu.count) {
			return - 1;
		} else if (this.count < stu.count) {
			return 1;
		} else {
			return 0;
		}
	}
}
