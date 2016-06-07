package bj.mldn.javase01.no77.Collection.collectiondemo.listdemo;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListPrintDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Collection< String > allList = new ArrayList< String >();   // 为Collection接口实例化
		allList.add( "hello" );   // 增加元素，Collection接口定义
		allList.add( "MLDN" );    // 增加元素，Collection接口定义
		allList.add( "world" );   // 增加元素，Collection接口定义
		String obj[] = allList.toArray( new String[]{} );
		for ( int i = 0; i < obj.length; i++ ) {  // 循环输出
			String str = obj[ i ];
			System.out.println( str );
		}
	}
}
