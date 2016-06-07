package bj.mldn.javase02.ch06.no02;

class Person2 {        // 定义父类

	public void print() {    // 默认的访问权限
		System.out.println( "Person --> void print()。" );
	}
}

class Student2 extends Person2 {    // 定义继承关系

	/*
	void print() {    // 错误的，降低了访问权限
		System.out.println("Student --> void print()。");
	}
	*/

}
