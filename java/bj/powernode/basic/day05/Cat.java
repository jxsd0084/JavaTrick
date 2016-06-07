package bj.powernode.basic.day05;

// 定义包结构

/*

	java语言中的 static关键字
	带有static关键字的语句,我们通常都称作是 “静态的”
	
	如何定义 “成员变量” ?
		private String name;
		
	如何定义 “静态变量” ?
		private static int sid;
		
	如何定义 “普通方法” ?
		public void m(){}
	
	如何定义 “静态方法” ?
		public static void m(){}
		
	
	1.实例变量(成员变量)
	2.静态变量
	3.实例方法
	4.静态方法

*/
public class Cat {

	//  成员变量 (实例变量) (对象级别变量)
	private String name;

	//  静态成员变量 (静态变量) (类级别变量)
	//  类级别的变量: 所有Cat类型的对象共享的一个变量.
	private static int sid;


	//  定义“普通方法”  (实例方法) (对象级别的方法:必须使用 "对象名." 调用)
	public void catchAnimal( String animalName ) {

		System.out.println( "猫在抓" + animalName );

	}

	//  定义静态方法 (类级别的方法. 无需对象的存在即可调用.)
	public static void m() {

		System.out.println( "m method invoked!" );
	}


	//  主方法
	public static void main( String[] args ) {

		//  name = "jack";  //  报错 : 在静态的上下文中无法去引用非静态的变量 name

		//  1.访问实例变量
		Cat c1 = new Cat();
		c1.name = "tom";

		System.out.println( "c1对象的name=" + c1.name );

		//  2.访问 静态变量(类级别的变量,所有对象共享的.)
		Cat.sid = 10;
		System.out.println( "从类Cat中获取sid值=" + Cat.sid );


		//  ???? sid属性可以用对象来访问吗？ 可以的.一般不推荐.
		System.out.println( "从对象中获取sid的值=" + c1.sid );


		//  执行实例方法.
		c1.catchAnimal( "jerry" );


		//  执行静态方法
		Cat.m();


	}


}
