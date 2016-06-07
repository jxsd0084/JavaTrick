package bj.powernode.basic.day13.generic;

import java.util.*;


/*

	设计原则：能在编译期解决的问题绝对不在运行期解决.
	
	不使用java >=1.5 之后的泛型.
	
	Set集合存储元素.

*/
public class Test01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Set datas = new HashSet();  // Set集合中存储的元素类型杂乱无章.类型不够统一,管理不方便.

		datas.add( 1 );
		datas.add( new Integer( 10 ) );
		datas.add( new String( "hello" ) );
		datas.add( "world" );
		datas.add( 1.23 );



		System.out.println( "datas集合中有" + datas.size() + "个元素." );


		Iterator it = datas.iterator();
		while ( it.hasNext() ) {

			Object obj = it.next();  // 不使用泛型,每次使用的时候还需要强制类型转换.

			// 强制类型转换.
			if ( obj instanceof Integer ) {

				Integer i = (Integer) obj;
				System.out.println( i.intValue() + 100 );  //101 110
			}

			if ( obj instanceof String ) {

				String str = (String) obj;
				System.out.println( new StringBuffer( str ).reverse() ); // 倒序输出.  olleh  dlrow
			}

			if ( obj instanceof Double ) {

				Double d = (Double) obj;
				System.out.println( d.doubleValue() + 0.77 ); // 2.0
			}

		}

	}

}

