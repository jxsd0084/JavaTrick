package bj.mldn.javase02.ch06.no01;

class Person1 {                    // 定义Person类

	private String name;           // 定义name属性
	private int    age;            // 定义age属性

	public void setName( String name ) {

		this.name = name;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public int getAge() {

		return this.age;
	}
};

class Student1 {                 // 定义Student类

	private String name;         // 定义name属性
	private int    age;          // 定义age属性
	private String school;       // 定义school属性

	public void setName( String name ) {

		this.name = name;
	}

	public void setAge( int age ) {

		this.age = age;
	}

	public String getName() {

		return this.name;
	}

	public int getAge() {

		return this.age;
	}

	public void setSchool( String school ) {

		this.school = school;
	}

	public String getSchool() {

		return this.school;
	}
}
