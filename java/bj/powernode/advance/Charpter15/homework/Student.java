package bj.powernode.advance.Charpter15.homework;

/*

 【程序1】

 已存在config.txt文件，内容如下：
 className:Student
 constructorParameter:String
 methodName:printName
 methodParameter:String
 编写程序，使用Properties读取config.txt文件的内容,
 并根据读到的参数生成一个对象，并调用相应的方法。

 */

// 准备学术类Student
public class Student {

	// 属性String类型 name
	private String name;

	// printName方法重载1,参数:String类型 str
	private void printName( String str ) {

		System.out.println( name + " 对象的 printName()方法 被调用,参数是:" + str );
	}

	// printName方法重载2,参数:String类型 str和int类型 age
	private void printName( String str, int age ) {

		System.out.println( name + " 对象的 printName()方法 被调用,参数是:" + str );
	}

	// 有参构造1,参数:String类型 name
	private Student( String name ) {

		this.name = name;
	}

	// 有参构造2,参数:String类型 name,int类型 age
	private Student( String name, int age ) {

		this.name = name;
	}
}
