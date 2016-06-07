package bj.DesignPattern.JavaAndPattern.decorator;

public class Decorator implements Component {

	public Decorator( Component component ) {
//        super();
		this.component = component;
	}

	public Decorator() {
	}

	public void sampleOperation() {
		component.sampleOperation();
	}

	/**
	 * @link aggregation
	 */
	private Component component;

}
