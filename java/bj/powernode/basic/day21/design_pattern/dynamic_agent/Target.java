package bj.powernode.basic.day21.design_pattern.dynamic_agent;

/**
 * 动态代理中的目标类
 */
public class Target {  //目标类

	public boolean method( String s1, String s2 ) {  //目标方法
		return s1.equals( s2 );
	}
}
