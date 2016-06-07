package bj.powernode.basic.day04;

//  创建类
public class Customer {

	//  成员变量 (属性)
	int id;                                    //  默认值 0

	double weight;                             //  默认值 0.0

	boolean sex;                               //  默认值 false

	//  所有的引用类型如果没有显示赋值,默认的都是"null".
	String name;                               //   默认值 null

	String address = "北京海淀中关村东路18号";    //   默认值 null


	//  创建shopping(){}方法
	void shopping() {
		
		/*
		
		  返回值 ---> 一般函数都是被用来调用的，返回值就是你调用函数的运行结果.

		  返回值 ---> 变量是具有作用域的，一般在函数里面声明的变量的作用域即是在函数里面，函数运行结束以后就会消失,

		  返回值 ---> 这时候返回一个值就可以使你获取到函数的运行结果.

		  返回值 ---> 当然，你可以不用返回值，设置全局变量或者是通过传递引用参数来获取到程序的运行结果.

		  返回值 ---> 但是返回值最简单的.
		
		*/

		System.out.println( "customer shopping." );

	}

	//  主方法.
	public static void main( String[] args ) {

	}

}
