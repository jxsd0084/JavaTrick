package bj.DesignPattern.JavaAndPattern.factorymethod;

public class ConcreteCreator1 implements Creator {

	public Product factory() {
		return new ConcreteProduct1();
	}

}
