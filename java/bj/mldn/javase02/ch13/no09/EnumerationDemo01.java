package bj.mldn.javase02.ch13.no09;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Vector< String > all = new Vector< String >();
		all.add( "hello" );
		all.add( "_" );
		all.add( "world" );
		Enumeration< String > enu = all.elements();
		while ( enu.hasMoreElements() ) {                   // 判断是否有内容，hasNext()
			System.out.print( enu.nextElement() + "、" );    // 输出元素：next()
		}
	}
}
