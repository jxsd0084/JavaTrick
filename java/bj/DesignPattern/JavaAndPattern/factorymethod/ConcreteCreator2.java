package bj.DesignPattern.JavaAndPattern.factorymethod;

public class ConcreteCreator2 implements Creator {

	public Product factory() {
		return new ConcreteProduct2();
	}

}
