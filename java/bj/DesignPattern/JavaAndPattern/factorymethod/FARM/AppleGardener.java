package bj.DesignPattern.JavaAndPattern.factorymethod.FARM;

public class AppleGardener implements FruitGardener {

	public Fruit factory() {
		return new Apple();
	}

}
