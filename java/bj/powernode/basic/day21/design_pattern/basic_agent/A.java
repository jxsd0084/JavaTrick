package bj.powernode.basic.day21.design_pattern.basic_agent;


/**
 * 必须通过A类去执行B类的m方法.A类应该如何编写?
 */
public class A {  //代理类,代理B去执行m方法.
	
	private B b;
	
	public A(B b){
		this.b = b;
	}
	
	public void m(){  //代理方法
//		System.out.println("执行开始");
		long begin = System.currentTimeMillis();
		b.m();  //目标类的目标方法调用.
//		System.out.println("执行结束");
		long end = System.currentTimeMillis();
		
		System.out.println("m方法执行耗时="+(end-begin));
	}
	
}

