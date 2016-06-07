package bj.powernode.basic.day04;
/*
	
	0. 如何创建一个对象:"new"关键字 + 构造方法.

	1.构造方法的作用:专门用来创建对象的。构造方法在创建对象的时候被调用.
	
	2.构造方法的语法:
	 
		构造方法没有返回值类型.
		
		构造方法的方法名必须和类名一致.
		
		例如: Animal(){}
	
	3.如果一个类没有定义构造方法,那么系统会默认给你提供一个 “类名(){}” 构造方法.
	
	 “类名(){}”样子的构造方法,我们称作“无参构造/缺省构造器/缺省构造方法”.
	 
	4.构造方法可以有多个.

*/

// 创建类
public class Animal {

	//  构造方法 1 (无参构造).
	Animal() {

		System.out.println( "Animal类型的对象正在被创建." );
	}


	//  构造方法 2 (有参构造).
	Animal( String name ) {

		System.out.println( "Animal's name is " + name );
	}


	//  构造方法 3
	Animal( String name, int age ) {

		System.out.println( "Animal's name is " + name + "and age is " + age );
	}


	//  普通方法m1.
	void m1() {

		System.out.println( "m1 method invoked!" );
	}

	//  程序的入口
	public static void main( String[] args ) {

		//  调用构造方法去创建对象.
		Animal a1 = new Animal();

		Animal a2 = new Animal( "狒狒" );

		Animal a3 = new Animal( "Pan Pan", 10 );

	}

}
