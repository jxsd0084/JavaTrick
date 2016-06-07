
package bj.DesignPattern.JavaAndPattern.ITERATOR.copsandsales;

public class CartOfCopA extends ShoppingCart {

	public CartOfCopA() {
	}

	public Iterator createIterator() {
		return new ForwardIterator( this );
	}

} 
