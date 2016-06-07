package bj.mldn.javase02.ch06.no01;

class Person5 {                 // 定义Person类

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
class Student5 extends Person5 {

	public void fun() {

		System.out.println( "父类中的name属性：" + getName() );  // 正确，间接访问
		System.out.println( "父类中的age属性：" + getAge() );    // 正确，间接访问
	}

}
