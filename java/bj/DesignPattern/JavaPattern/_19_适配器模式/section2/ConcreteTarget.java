package bj.DesignPattern.JavaPattern._19_适配器模式.section2;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class ConcreteTarget implements Target {

	public void request() {
		System.out.println( "I have nothing to do. if you need any help,pls call me!" );
	}

}
