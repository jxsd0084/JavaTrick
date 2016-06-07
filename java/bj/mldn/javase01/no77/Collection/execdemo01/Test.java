package bj.mldn.javase01.no77.Collection.execdemo01;

import java.util.Iterator;
import java.util.List;

public class Test {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		SuperMarket mak = new SuperMarket();
		mak.add( new Book( "Java", 2, 30.9f ) );
		mak.add( new Book( "C++", 3, 10.9f ) );
		mak.add( new Book( "JSP", 5, 80.9f ) );
		print( mak.search( "J" ) );
		mak.remove( new Book( "Java", 2, 30.9f ) );
		print( mak.search( "J" ) );
	}

	public static void print( List all ) {

		Iterator iter = all.iterator();
		while ( iter.hasNext() ) {
			System.out.println( iter.next() );
		}
	}
}
