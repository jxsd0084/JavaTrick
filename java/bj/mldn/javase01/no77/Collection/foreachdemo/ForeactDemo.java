package bj.mldn.javase01.no77.Collection.foreachdemo;

import java.util.ArrayList;
import java.util.List;

public class ForeactDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		List< String > allList = new ArrayList< String >();
		allList.add( "A" );
		allList.add( "B" );
		allList.add( "C" );
		allList.add( "D" );
		allList.add( "E" );
		for ( String str : allList ) {
			System.out.print( str + "、" );
		}
	}

}
