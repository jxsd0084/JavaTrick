package bj.DesignPattern.JavaAndPattern.ITERATOR.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class Cient {

	private static LinkedList ll = new LinkedList();
	private static Iterator it;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		ll.add( new String( "Age: " ) );
		ll.add( new Integer( 35 ) );
		ll.add( new String( "Career: " ) );
		ll.add( new String( "Bug selling" ) );

		it = ll.listIterator( 0 );

		while ( it.hasNext() ) {

			System.out.println( it.next() );
		}

	}

}
