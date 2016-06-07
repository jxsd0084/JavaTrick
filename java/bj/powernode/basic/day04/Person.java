package bj.powernode.basic.day04;
/*

	类：一种事物的抽象
	对象：一个类的具体实现

	类：人类
	对象： 杨利伟
	
	对象和对象之间是有差异的.
	
	世间万物皆对象
	每一个对象都有（静属性和动属性）
	
	代码去实现一个类：用成员变量对应 静属性
			  用方法(函数)对应 动属性
	
	
	类 = 成员变量 + 方法.
	类 = 属性 + 方法. 
	类 = 成员变量 + 函数
	类 = 属性 + 函数.
	
	"class = attribute + method"

*/

public class Person{

	//  抽象出Person类的静属性(成员变量).

	//  名字(静属性).

	//  成员变量我们通常又叫做属性.
		
	String name;



	//  抽象出Person类的动属性(方法/函数).

	//  吃饭(动属性).

	//  方法又被一些程序员称作-函数.

	void eat(){
		
		System.out.println("eating");
		
	}

}
