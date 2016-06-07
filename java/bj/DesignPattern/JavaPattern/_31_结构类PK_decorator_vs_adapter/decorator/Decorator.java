package bj.DesignPattern.JavaPattern._31_结构类PK_decorator_vs_adapter.decorator;

/**
 * @author cbf4Life cbf4life@126.com
 *         I'm glad to share my knowledge with you all.
 */
public class Decorator implements Swan {

	private Swan swan;

	// 修饰的是谁
	public Decorator( Swan _swan ) {
		this.swan = _swan;
	}

	public void cry() {
		swan.cry();
	}

	public void desAppaearance() {
		swan.desAppaearance();
	}

	public void fly() {
		swan.fly();
	}

}
