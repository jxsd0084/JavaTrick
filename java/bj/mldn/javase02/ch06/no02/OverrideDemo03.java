package bj.mldn.javase02.ch06.no02;

class Person3 {        // 定义父类

	void print() {    // 默认的访问权限
		System.out.println( "Person --> void print()。" );
	}
}

class Student3 extends Person3 {    // 定义继承关系

	public void print() {

		super.print();    // 访问父类中被子类覆写过的方法
		System.out.println( "Student --> void print()。" );
	}
}

public class OverrideDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Student3 s = new Student3();
		s.print();
	}
}
