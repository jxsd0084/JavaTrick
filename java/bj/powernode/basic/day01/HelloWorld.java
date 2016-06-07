package bj.powernode.basic.day01;

/**
 * java开发前的准备:
 * 1. 安装JDK
 * 2. 配置环境变量
 * PATH=JDK的安装根路径  (好让windows操作系统找到对应的命令.)
 * CLASSPATH=类路径 (好让java程序找到 “类”)
 * java命令： java 类名 (java在运行某个类的时候需要先找到它，是通过CLASSPATH找的。)
 */

/*

	一个.java源文件中最基本的单元是 “类”

	一个.java源文件中可以定一个多个class

	一个class对应编译生成一个对应.class文件

	一个.java源文件中只能有一个public的类

	.java的文件名必须和public的类名一致.

*/

/*
	关键字public 访问修饰符 (公开的)，在我们的java程序中将来会有很多的类,这个类是否可以被其他的类访问.可以通过“访问修饰符”来控制访问权限

	关键字class 定义类必须的。

	HelloWorld 是“类名”

	HelloWorld后面的 {} 是“类体”

	public static void main(String[] args); 程序的入口(固定写法.称作类的主方法)
*/

// 类名规范：类名的首字母大写,后面的每个单词的首字母大写。
public class HelloWorld {

	//  void 表示该方法没有返回值
	//  main 是方法名
	//  main后面的 () 存放的是该方法的参数列表
	//  main方法后面的 {} 是 “方法体”
	public static void main( String[] args ) {

		System.out.println( "Hello World!" );   // 称作java语句,这个语句功能是向java“控制台”打印一段信息。
		
		/*
			java语句可以放在同一行，但是不推荐这样做。推荐一条java语句占一行。
			java语句和语句之间用 ; 来分割
		*/
		System.out.println( "username is jack!" );

	}

}


//  这是一个最简单的类
class T {

}

class TT {

}
