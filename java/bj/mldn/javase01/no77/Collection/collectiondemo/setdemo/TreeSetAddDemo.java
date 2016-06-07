package bj.mldn.javase01.no77.Collection.collectiondemo.setdemo;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetAddDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Set< String > allSet = new TreeSet< String >();
		allSet.add( "C" ); // 增加重复元素
		allSet.add( "D" ); // 增加
		allSet.add( "E" ); // 增加
		allSet.add( "A" ); // 增加
		allSet.add( "B" ); // 增加
		allSet.add( "C" ); // 增加
		allSet.add( "C" ); // 增加重复元素
		System.out.println( allSet );
	}

}
