package bj.mldn.javase01.no77.Collection.enumerationdemo;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Vector< String > allList = new Vector< String >();
		allList.add( "A" );
		allList.add( "B" );
		allList.add( "C" );
		allList.add( "D" );
		allList.add( "E" );
		Enumeration< String > enu = allList.elements();
		while ( enu.hasMoreElements() ) {
			System.out.print( enu.nextElement() + "、" );
		}
	}

}
