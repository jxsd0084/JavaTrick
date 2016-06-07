package bj.mldn.javase02.ch13.no09;

import java.util.ArrayList;
import java.util.List;

public class ForeachDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		List< String > all = new ArrayList< String >();
		all.add( "hello" );
		all.add( "_" );
		all.add( "world" );
		for ( String str : all ) {
			System.out.print( str + "、" );
		}
	}
}
