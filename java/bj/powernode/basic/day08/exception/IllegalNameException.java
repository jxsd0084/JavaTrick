package bj.powernode.basic.day08.exception;
/*

	在java语言中如何自定义异常.

		1.如何自定义一个检查时异常.

		2.如何自定义一个运行时异常.

*/

public class IllegalNameException extends Exception{  //检查时异常
	
	// 无参构造
	public IllegalNameException(){}
	
	// 有参数构造.
	public IllegalNameException(String msg){

		super(msg);  // 父类的构造方法.
	}
	
}
