package bj.powernode.basic.day21.design_pattern.basic_agent;

public class Test {

	/**
	 * 写一段程序,通过A类去执行B类中m方法.
	 * 
	 * A类称作代理类
	 * B类称作目标类(B类中的m方法称作目标方法)
	 */
	public static void main(String[] args) {
		
		//1.创建代理对象
		A a = new A(new B());
		
		//2.调用代理类的代理方法去执行目标类的目标方法
		a.m();
		
	}

}
