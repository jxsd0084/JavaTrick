package bj.DesignPattern.JavaAndPattern.simplefactory;

public class Creator {

	public static Product factory() {
		return new ConcreteProduct();
	}

	/** @link dependency
	 * @label Creates*/
	/*# ConcreteProduct lnkConcreteProduct; */

}
