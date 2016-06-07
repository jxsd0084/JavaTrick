package bj.mldn.javase02.ch13.no02;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		List< String > allList = null;
		allList = new ArrayList< String >();    // 指定操作的泛型为String
		allList.add( "Hello" );                 // 此方法由Collection接口而来
		allList.add( 0, "World" );              // 在第一个位置上添加新的内容
		allList.add( "MLDN" );                  // 向Collection中加入内容
		allList.add( "www.mldn.cn" );
		allList.remove( 0 );                    // 删除第一个元素，指定删除的位置
		allList.remove( "Hello" );              // 此方法由Collection接口继承而来
		System.out.println( allList );
	}
}
