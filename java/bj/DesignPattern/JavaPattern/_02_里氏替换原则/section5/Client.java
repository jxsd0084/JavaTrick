package bj.DesignPattern.JavaPattern._02_里氏替换原则.section5;

import java.util.HashMap;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class Client {

	public static void invoker() {
		// 有父类的地方就有子类
		// Father f= new Father();
		Son     f   = new Son();
		HashMap map = new HashMap();
		f.doSomething( map );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		invoker();

	}

}
