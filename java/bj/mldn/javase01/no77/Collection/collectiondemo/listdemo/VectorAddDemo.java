package bj.mldn.javase01.no77.Collection.collectiondemo.listdemo;

import java.util.List;
import java.util.Vector;

public class VectorAddDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		List< String > allList = new Vector< String >();    // 为List接口实例化
		allList.add( "hello" );   // 增加元素，Collection接口定义
		allList.add( 0, "MLDN" ); // 增加元素，List接口定义
		allList.add( "world" );   // 增加元素，Collection接口定义
		System.out.println( allList );
	}
}
