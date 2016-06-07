package bj.mldn.javase01.no77.Collection.collectiondemo.setdemo;

import java.util.HashSet;
import java.util.Set;

public class HashSetAddDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Set< String > allSet = new HashSet< String >();
		allSet.add( "A" ); // 增加
		allSet.add( "B" ); // 增加
		allSet.add( "C" ); // 增加
		allSet.add( "C" ); // 增加重复元素
		allSet.add( "C" ); // 增加重复元素
		allSet.add( "D" ); // 增加
		allSet.add( "E" ); // 增加
		System.out.println( allSet );
	}

}
