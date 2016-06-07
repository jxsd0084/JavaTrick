package bj.mldn.javase02.ch13.no04;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Set< String > allSet = new HashSet< String >();
		allSet.add( "A" );    // 增加内容
		allSet.add( "B" );    // 增加内容
		allSet.add( "C" );    // 增加内容
		allSet.add( "C" );    // 重复内容
		allSet.add( "C" );    // 重复内容
		allSet.add( "D" );    // 增加内容
		allSet.add( "E" );    // 增加内容
		System.out.println( allSet );
	}
}
