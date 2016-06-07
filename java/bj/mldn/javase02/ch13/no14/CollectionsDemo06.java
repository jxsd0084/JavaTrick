package bj.mldn.javase02.ch13.no14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo06 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		List< String > all = new ArrayList< String >();    // 返回空的 List集合
		Collections.addAll( all, "1、MLDN", "2、LXH", "3、mldnjava" );
		Collections.addAll( all, "B、www.mldn.cn" );
		Collections.addAll( all, "A、www.mldnjava.cn" );
		System.out.println( "排序之前的集合：" + all );
		Collections.sort( all );
		System.out.println( "排序之后的集合：" + all );

	}
}
