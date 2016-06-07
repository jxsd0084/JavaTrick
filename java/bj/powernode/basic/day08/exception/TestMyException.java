package bj.powernode.basic.day08.exception;

public class TestMyException{
	
	/**
	 * 测试
 	 * @param args
	 */
	public static void main(String[] args) throws IllegalNameException{
		
		User u = new User();
		
		// 第一种方式
		// try{
		//	 u.m1();
		// }catch(IllegalNameException e){
		//	 e.printStackTrace();
		// }
		
		// 第二种方式:上抛
		
		
		
	}
}


class User{
	
	public void m1() throws IllegalNameException{  // 在方法上上抛异常.

		System.out.println("m1 method invoked!");
	}
	
}
