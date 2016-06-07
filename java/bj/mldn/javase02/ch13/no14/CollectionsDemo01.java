package bj.mldn.javase02.ch13.no14;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class CollectionsDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		List< String > allList = Collections.emptyList();    // 返回空的 List集合
		Set< String >  allSet  = Collections.emptySet();    // 返回空的 List集合
		allList.add( "Hello" );    // 加入数据
	}
}
