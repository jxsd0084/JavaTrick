package bj.DesignPattern.JavaAndPattern.VISITOR.inventory;

abstract class Equipment {

	public abstract void accept( Visitor vis );

	public abstract double price();

}
