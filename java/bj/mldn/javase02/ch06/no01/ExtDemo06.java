package bj.mldn.javase02.ch06.no01;

class Person4 {                 // 定义Person类

	private String name;        // 定义name属性
	private int    age;         // 定义age属性

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
}

// 定义Student类
class Student4 extends Person4 {

	public void fun() {

//		System.out.println("父类中的name属性：" + name);  // 错误，无法访问
//		System.out.println("父类中的age属性：" + age);    // 错误，无法访问
	}

}
