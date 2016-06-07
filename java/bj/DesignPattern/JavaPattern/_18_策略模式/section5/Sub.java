package bj.DesignPattern.JavaPattern._18_策略模式.section5;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class Sub implements Calculator {

	// 减法
	public int exec( int a, int b ) {
		return a - b;
	}

}
