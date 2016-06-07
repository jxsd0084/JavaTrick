package bj.DesignPattern.JavaPattern._10_模板方法模式.section3;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class ConcreteClass2 extends AbstractClass {

	// 实现基本方法
	protected void doAnything() {
		// 业务逻辑处理
		System.out.println( "ConcreteClass2 doAnything" );
	}

	protected void doSomething() {
		// 业务逻辑处理
		System.out.println( "ConcreteClass2 doSomething" );
	}

}
