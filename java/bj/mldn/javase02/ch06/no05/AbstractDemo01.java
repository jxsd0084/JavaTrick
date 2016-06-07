package bj.mldn.javase02.ch06.no05;

abstract class A {    // 是定义了一个抽象类

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
