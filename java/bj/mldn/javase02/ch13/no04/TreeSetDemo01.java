package bj.mldn.javase02.ch13.no04;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Set< String > allSet = new TreeSet< String >();
		allSet.add( "C" );    // 增加内容
		allSet.add( "C" );    // 重复内容
		allSet.add( "C" );    // 重复内容
		allSet.add( "D" );    // 增加内容
		allSet.add( "B" );    // 增加内容
		allSet.add( "A" );    // 增加内容
		allSet.add( "E" );    // 增加内容
		System.out.println( allSet );
	}
}
