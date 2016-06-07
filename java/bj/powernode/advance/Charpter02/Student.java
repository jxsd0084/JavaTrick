package bj.powernode.advance.Charpter02;

// java从类的层次开始支持面向对象

// 类里面是该类对象所共有的属性和方法
public class Student {

	int    age;
	String name;

	// 在类的方法中,可以直接使用类中的属性
	public void study( String className ) {

		System.out.println( name + " 同学在学习:" + className );

	}

}
