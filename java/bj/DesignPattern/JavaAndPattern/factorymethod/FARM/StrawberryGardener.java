package bj.DesignPattern.JavaAndPattern.factorymethod.FARM;

public class StrawberryGardener implements FruitGardener {

	public Fruit factory() {
		return new Apple();
	}

}
