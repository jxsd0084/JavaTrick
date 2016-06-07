package bj.powernode.basic.day21.design_pattern.static_agent;


/**
 * 代理模式中的目标类
 *
 * @author Administrator
 */
public class Target implements CommonInterface {

	public boolean method() {  //目标方法
		try {
			Thread.sleep( 1234 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		System.out.println( "目标类的目标方法执行" );
		return false;
	}


	public void m() {  //目标方法
		System.out.println( "m method invoked!" );
	}

}
