package bj.powernode.basic.day05.inherit;

/*

	java语言中的继承关系.
	在java语言中只有“单继承”
	
	B类继承A类,会将A类中的所有东西全部继承(属性+方法)
	
	如果A类中定义了A方法,B类去继承A类，那么B类就可以使用A类的A方法.
	
	语法: extends 关键字.
	
	继承关系中有很多名字:
		父类(基类)  super class
		子类(派生类) sub class

*/
public class Animal {

	private String name;
	private int    age;

	public void run() {

		System.out.println( "动物在跑." );
	}


}




