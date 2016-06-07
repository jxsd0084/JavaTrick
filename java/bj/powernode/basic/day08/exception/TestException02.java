package bj.powernode.basic.day08.exception;

import java.io.*;


/*
	
	处理异常的第二种方式: 上抛
	
		A方法调用B方法，B方法又调用C方法.(A--->B-->C)
		
		
		C方法出现了异常,如果在C方法中没有try catch，会上抛给B方法,如果B方法中没有try catch，会继续上抛给A方法.
		
		如果A方法中没有try catch,会上抛给main方法,main方法抛给JVM,JVM遇到异常程序结束.

*/
public class TestException02{

	/**
	 * 测试
 	 * @param args
	 */
	// public static void main(String[] args) throws FileNotFoundException{
	public static void main(String[] args) throws Exception{ // 不推荐,原则：能处理绝不上抛.
		
		
		// IO,获取 读取c:/testException.txt 的流
		
		// 为什么编译无法通过？
		//	FileInputStream这个构造方法上抛了一个 FileNotFoundException,是一个检查时异常.要求必须对它进行处理.

		// 该构造方法定义的时候上抛了一个 FileNotFoundException(检查时异常.)
		//  FileInputStream in = new FileInputStream("c:/testException.txt");

		
		// 第一种处理方式:try catch处理.
		// try{
		//	FileInputStream in = new FileInputStream("c:/testException.txt"); 
		// }catch(FileNotFoundException e){
		//	e.printStackTrace();
		// }
		
		
		// 第二种处理方式:上抛
		// 异常的设计原则: 明显的异常通常被设计成检查异常,不明显的异常通常被设置成运行时异常.
		FileInputStream in = new FileInputStream("c:/testException.txt"); 
		
		
		System.out.println("HelloWorld.");
		
	}

}
