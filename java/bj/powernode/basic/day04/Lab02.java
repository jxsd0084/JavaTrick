package bj.powernode.basic.day04;

public class Lab02 {


	static String str;  //  默认值是 null

	//  主方法
	public static void main( String[] args ) {

		//  声明一个基本类型的变量.

		int i = 10;  // 基本类型. 基本类型中存储的是-基本类型的数据.


		//  在java语言中除了基本数据类型之外,还有引用类型.

		//  注意：我们使用new关键字来创建一个对象.

		String s = new String( "hello world!" );  //    s是一个变量(引用类型变量.)

		//  引用类型的变量中存储的是 一个对象在堆空间中的内存地址.

		//  注意:如果一个引用类型是null. 调用这个引用类型对象的方法的时候,会出现(空指针异常-NullPointerException).
			
			
		/*
		  空指针异常---> 什么是NULL?

            The macro（ 宏）NULL is defined in <stddef.h> (and other headers) as a null pointer constant

           （NULL作为一个宏定义为一个空指针常量）.

            即,NULL 是一个标准规定的宏定义,用来表示空指针常量.因此,除了上面的各种赋值方式之外,还可以用 p = NULL;来使 p 成为一个空指针.
		*/

		//  如何去执行一个对象的方法.(对象名.方法名(实参列表))

		int sLength = s.length();

		System.out.println( "s字符串的长度：" + sLength );

		//  int strLength = str.length();                              //   会导致空指针异常.

		//  System.out.println("str字符串的长度："+strLength);

		//  如果方法中有static关键字,如何执行方法?(类名.方法名(实参列表))


		Lab02.m1();                                                    //   m1(); (类名.方法名(实参列表))

		//  执行m2方法.  (对象名.方法名(实参列表))

		Lab02 lab02 = new Lab02();                                     //  创建一个Lab02类型的对象 lab02

		lab02.m2();

	}


	static void m1() {

		System.out.println( "static m1 method invoked!" );

	}


	void m2() {

		System.out.println( "m2 method invoked!" );

	}

}
