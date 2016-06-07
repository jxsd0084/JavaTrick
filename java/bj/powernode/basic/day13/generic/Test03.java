package bj.powernode.basic.day13.generic;

/*

	java.util.Map使用泛型

*/

import java.util.*;

public class Test03 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Map< Integer, Student > stus = new HashMap< Integer, Student >();

		stus.put( 1, new Student( "jack" ) );
		stus.put( 2, new Student( "lucy" ) );
		stus.put( 3, new Student( "sun" ) );
		stus.put( 4, new Student( "cock" ) );


		// 遍历
		Set< Integer >      ins = stus.keySet();
		Iterator< Integer > it  = ins.iterator();
		while ( it.hasNext() ) {
			Integer i = it.next();      // key
			Student s = stus.get( i );  // value

			System.out.println( i + "-->" + s );
		}

	}

}
