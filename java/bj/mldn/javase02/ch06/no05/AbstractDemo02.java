package bj.mldn.javase02.ch06.no05;

abstract class A2 {    // 是定义了一个抽象类

	public static final String FLAG = "CHINA";    // 全局常量
	private             String name = "李兴华";    // 定义一个普通的属性

	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return this.name;
	}

	public abstract void print();        // 定义抽象方法
}

class B2 extends A2 {    // 继承抽象类，因为B是普通类，所以必须覆写全部抽象方法

	public void print() {

		System.out.println( "FLAG = " + FLAG );
		System.out.println( "姓名 = " + super.getName() );
	}
}

public class AbstractDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		B2 b = new B2();
		b.print();
	}
}
