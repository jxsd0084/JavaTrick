package bj.powernode.basic.day08.exception;

/*

	关于java中的异常机制.
	
	1.什么是异常? 
		程序在运行阶段报出的错误.出现的异常情况.

*/
public class TestException01{

	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String[] args){
		
		int[] i = {1,2};
		
		// System.out.println(i[3]); // 异常情况.  java.lang.ArrayIndexOutOfBoundsException
	    // 程序执行到此,发生了异常,并且没有做任何的处理.程序就终止了.
	    // 程序是如此的脆弱.
					  
					  
		// 如何在程序出现异常后，后面的代码还能够继续执行,让我们的程序更加健壮.需要用到java中的异常处理机制.
		System.out.println("Hello World1.");
		
		/*
			在java语言中异常也是类.

			SUN把所有的异常都定义成了类.
			
			如何处理异常?

				在有可能出现异常的地方，用try,catch来进行处理.具体语法如下.
				
				try{
					java语句1;
					java语句2;  //如果java语句2抛出了异常,java语句3将不再执行.  出现异常后自动由系统生成异常对象.
					java语句3;
					....
					
				}catch(AException ae){
					//抓到AException类型的异常会执行此处代码.

				}catch(BException be){
					//抓到BException类型的异常会执行此处代码.

				}catch(CException ce){
					//抓到CException类型的异常会执行此处代码.				
				}
		*/
		
		try{
			
			System.out.println(10/0); // 0不能作为除数.异常现象.  java.lang.ArithmeticException
			
			System.out.println("Hello World3.");  // 程序不会执行.
			
		}catch(ArithmeticException ae){
			
			// System.out.println("除数不能为0");
			// System.out.println("程序出现异常，请联系开发人员.");
			// System.out.println("网络延迟，请稍候再试.");
			
			// 在程序开发阶段，推荐这么去处理异常.
			// 在java语言中任何一个异常对象都有一个方法 printStackTrace(),该方法的作用是打印异常堆栈.
			ae.printStackTrace();
			
			// 在java语言中任何一个异常对象都有一个方法getMessage(),该方法的作用是获取异常信息.
			// System.out.println(ae.getMessage());
			
		}
		
		
		System.out.println("Hello World2.");
		
		
		try{
			
			int[] j = {1,2};
			
			System.out.println(j[3]);    // 数组下标越界
			
		}catch(ArithmeticException ae){  // 没有抓到异常,异常就不会被处理.
			
			System.out.println("算术异常.");
			
		}catch(ArrayIndexOutOfBoundsException e){
			
			e.printStackTrace();        // 打印异常堆栈.
			
		}
		
		System.out.println("Hello World4.");

		
		/*

		try{

			// 在java语言中java.lang.Exception 是 java.lang.ArithMeticException 的父类.

			// 结论：

				try{

				}catch(AException ae){

				}catch(BException be){

				}
				
				AException类型不能比BException类型更加”宽泛“.
			
			System.out.println(10/0); // 算术异常  ArithMeticException
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}catch(ArithmeticException e){
			
			e.printStackTrace();
			
		}
		*/
		
		
		try{
		
			// java语句1 (打开了一个文件.)
			// java语句2 (抛出了异常)
			// ava语句3 (关闭文件)
		
			System.out.println("Hello World5.");
			return; // 程序结束.
			
			
			
			
		}catch(Exception e){

			e.printStackTrace();
		}finally{
		
			// 关闭文件.
			System.out.println("finally execute."); // finally语句块中的代码肯定会执行.
		}
		
		
		// final finally finalize区别.

	}

}
