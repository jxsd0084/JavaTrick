package bj.powernode.basic.day21.design_pattern.agent;

/**
 * 充当代理模式中的代理类
 * @author Administrator
 *
 */
public class Agent implements CommonInterface{
	
	//在代理类中有一个目标类的引用
	private Target target;
	
	public Agent(Target target){
		this.target = target;
	}

	public void method() { //代理方法
		
		//额外代码
		long begin = System.currentTimeMillis();
		
		//执行目标类的目标方法
		target.method();
		
		//额外代码
		long end = System.currentTimeMillis();
		
		System.out.println("目标方法执行耗时"+(end-begin)+"毫秒");
		
	}

}
