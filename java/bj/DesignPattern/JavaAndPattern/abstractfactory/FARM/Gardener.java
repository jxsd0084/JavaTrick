package bj.DesignPattern.JavaAndPattern.abstractfactory.FARM;

public interface Gardener {

	public Fruit createFruit( String name );

	public Veggie createVeggie( String name );
}
