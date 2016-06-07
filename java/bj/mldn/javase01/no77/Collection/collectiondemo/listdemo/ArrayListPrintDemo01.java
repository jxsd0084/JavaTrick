package bj.mldn.javase01.no77.Collection.collectiondemo.listdemo;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPrintDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		List< String > allList = new ArrayList< String >();  // 为List接口实例化
		allList.add( "hello" );   // 增加元素，Collection接口定义
		allList.add( 0, "MLDN" ); // 增加元素，List接口定义
		allList.add( "world" );   // 增加元素，Collection接口定义
		for ( int i = 0; i < allList.size(); i++ ) {  // 循环输出
			System.out.println( allList.get( i ) );     // 输出内容
		}
	}
}
