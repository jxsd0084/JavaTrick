package bj.powernode.advance.Charpter12.test8;

import java.util.*;

public class CollectionsTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建LIst下面的ArrayList集合(数组)
		List< String > list = new ArrayList< String >();

		// 添加元素
		list.add( "aa" );
		list.add( "dd" );
		list.add( "ff" );
		list.add( "kk" );
		list.add( "gg" );
		list.add( "jj" );
		list.add( "cc" );

		// 调用Collections的sort方法给集合中的元素排序
		Collections.sort( list );

		// for循环遍历ArrayList集合;size() 返回此列表中的元素数
		for ( int i = 0; i < list.size(); i++ ) {

			// 输出取到的元素;get(int index) 返回此列表中指定位置上的元素
			System.out.println( list.get( i ) );
		}

	}

}
