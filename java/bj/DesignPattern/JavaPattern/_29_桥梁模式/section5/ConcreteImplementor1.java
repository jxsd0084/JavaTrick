package bj.DesignPattern.JavaPattern._29_桥梁模式.section5;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class ConcreteImplementor1 implements Implementor {

	public void doSomething() {
		// 业务逻辑处理
		System.out.println( "ConcreteImplementor1 -> doSomething" );
	}

	public void doAnything() {
		// 业务逻辑处理
		System.out.println( "ConcreteImplementor1 -> doAnything" );
	}

}
