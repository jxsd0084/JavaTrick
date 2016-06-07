package bj.mldn.javase02.ch13.no02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		List< String >       allList       = null;
		Collection< String > allCollection = null;
		allList = new ArrayList< String >();          // 指定操作的泛型为String
		allCollection = new ArrayList< String >();    // 指定一个集合
		allList.add( "Hello" );                       // 此方法由Collection接口而来
		allList.add( 0, "World" );                    // 在第一个位置上添加新的内容


		System.out.println( allList );
		allCollection.add( "LXH" );                   // 向Collection中加入内容
		allCollection.add( "www.mldn.cn" );
		allList.addAll( allCollection );
		allList.addAll( 0, allCollection );
		System.out.println( allList );
	}
}
