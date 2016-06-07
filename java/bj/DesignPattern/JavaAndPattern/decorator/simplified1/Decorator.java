package bj.DesignPattern.JavaAndPattern.decorator.simplified1;

public class Decorator extends ConcreteComponent {

	public Decorator( ConcreteComponent component ) {
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
	private ConcreteComponent component;

}
