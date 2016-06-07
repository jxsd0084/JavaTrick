package bj.Java1200.col01.ch10_Commons组件.ch10_4_CommonsBeanUtils组件简介._237;

public class Employee {

	private int    id;
	private String name;
	private double salary;

	public int getId() {

		return id;
	}

	public void setId( int id ) {

		this.id = id;
	}

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

	@Override
	public String toString() {

		return "员工编号：" + id + "，员工姓名：" + name + "，员工工资：" + salary;
	}
}
