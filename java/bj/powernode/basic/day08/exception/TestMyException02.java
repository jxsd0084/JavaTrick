package bj.powernode.basic.day08.exception;
/*

	在异常中掌握 5 个 关键字 :
	
		第一种异常的处理方式:
			try
			catch
			finally
		
		
		第二种异常处理方式:throws 通常写在方法后,来完成上抛异常
		
		
		throw 通常用来手动实现上抛异常. 例如:	throw new SomeException("testtest");

	掌握如何自定义异常.

*/

public class TestMyException02{
	
	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String[] args){

		User01 u = new User01();
		
		try{

			u.m1(17);

		}catch(IllegalAgeException e){
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("Hello World");

	}

}


class User01{
	
	public void m1(int age) throws IllegalAgeException{    // 运行时异常. 方法声明时抛出异常.

		System.out.println("m1 method invoked!");
		
		// 异常不能处理的,上抛.

		// 用代码实现手动上抛异常.
		if(age < 18){

			throw new IllegalAgeException("年龄小于18岁.");  // 手动抛出异常
		}

	}
	
}
