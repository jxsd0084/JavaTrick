package bj.mldn.javase02.ch06.no02;

class Person1 {        // 定义父类

	void print() {    // 默认的访问权限
		System.out.println( "Person --> void print()。" );
	}
}

class Student1 extends Person1 {    // 定义继承关系

	public void print() {

		System.out.println( "Student --> void print()。" );
	}
}

public class OverrideDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Student1 s = new Student1();
		s.print();
	}
}
