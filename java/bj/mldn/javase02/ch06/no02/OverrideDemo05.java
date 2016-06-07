package bj.mldn.javase02.ch06.no02;

class Person5 {        // 定义父类

	public String info = "MLDN";    // 定义一个公共属性
}

class Student5 extends Person5 {    // 定义继承关系

	public String info = "LXH";    // 定义了一个与父类中属性名称一致的属性

	void print() {    // 覆写父类中的方法
		System.out.println("父类中的属性：" + super.info);
		System.out.println("子类中的属性：" + this.info);
	}
}

public class OverrideDemo05 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main(String args[]) {

		Student5 s = new Student5();
		s.print();
	}
}
