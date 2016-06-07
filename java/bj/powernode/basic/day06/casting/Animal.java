package bj.powernode.basic.day06.casting;


/*

	int-->long  转型 (自动类型转换-->向上转型)
	long-->int 转型 (强制类型转换--> 向下转型)

	casting (java语言中的转型)
	
	转型分为两种: 
		向上转型 (up casting)
		向下转型 (down casting)

	Animal有两个子类: Dog,Cat
	
	Animal --> Dog (向下转型)
	Dog  --> Animal (向上转型)
	
	Animal --> Cat (向下转型)
	Cat -->  Animal (向上转型)
	
	
	Animal --> Dog / Cat (强制类型转换)
	
	Dog / Cat --> Animal (自动类型转换)
	
	
	注意：子类对象可以赋给父类引用.

*/
public class Animal {

	String name;
	int    age;

	public Animal() {

	}

	public Animal( String name, int age ) {

		this.name = name;
		this.age = age;
	}


	public void run() {

		System.out.println( "Animal is running." );
	}


	//  吃
	public void eat() {

		System.out.println( "动物在吃." );
	}


}
