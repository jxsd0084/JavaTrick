package bj.crazy.ch05.u09;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class Person {

	// 下面定义一个初始化块
	{
		int a = 6;
		// 在初始化块中
		if ( a > 4 ) {
			System.out.println( "Person初始化块：局部变量a的值大于4" );
		}
		System.out.println( "Person的初始化块" );
	}

	// 定义第二个初始化块
	{
		System.out.println( "Person的第二个初始化块" );
	}

	// 定义无参数的构造器
	public Person() {

		System.out.println( "Person类的无参数构造器" );
	}

	public static void main( String[] args ) {

		new Person();
	}

}
