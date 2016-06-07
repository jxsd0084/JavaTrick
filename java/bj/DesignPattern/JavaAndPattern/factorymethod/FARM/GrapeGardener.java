package bj.DesignPattern.JavaAndPattern.factorymethod.FARM;

public class GrapeGardener implements FruitGardener {

	public Fruit factory() {
		return new Apple();
	}

}
