package bj.DesignPattern.JavaAndPattern.ITERATOR.copsandsales;

public class CartOfCopB extends ShoppingCart {

	public CartOfCopB() {
	}

	public Iterator createIterator() {
		return new BackwardIterator( this );
	}

}
