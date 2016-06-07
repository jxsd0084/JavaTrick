package bj.Java1200.col01.ch05_面向对象技术应用.ch05_4_面向对象的特征._098_经理与员工的差异;

import java.util.Date;

public class Employee {

	private String name;
	private double salary;
	private Date   birthday;

	public String getName() {

		return name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public double getSalary() {

		return salary;
	}

	public void setSalary( double salary ) {

		this.salary = salary;
	}

	public Date getBirthday() {

		return birthday;
	}

	public void setBirthday( Date birthday ) {

		this.birthday = birthday;
	}

}
