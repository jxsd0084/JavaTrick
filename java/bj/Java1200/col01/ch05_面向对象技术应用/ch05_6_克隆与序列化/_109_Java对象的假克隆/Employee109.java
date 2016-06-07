package bj.Java1200.col01.ch05_面向对象技术应用.ch05_6_克隆与序列化._109_Java对象的假克隆;

public class Employee109 {

	private String name;
	private int    age;

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

	@Override
	public String toString() {

		return "姓名：" + name + ", 年龄：" + age;
	}
}
