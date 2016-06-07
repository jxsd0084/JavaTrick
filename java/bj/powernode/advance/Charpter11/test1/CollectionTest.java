package bj.powernode.advance.Charpter11.test1;

import java.util.*;

public class CollectionTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {




		// 泛型
		Collection< String > coll = new HashSet< String >();
		// 添加数据
		coll.add( "Hello1" );

		coll.add( "Hello2" );
		coll.add( "Hello3" );
		coll.add( "Hello2" );
		coll.add( "Hello4" );





		// 千万不要在遍历集合的过程中删除数据
		Iterator< String > it = coll.iterator();
		while ( it.hasNext() ) {
			String s = it.next();
			if ( s.equals( "Hello1" ) ) {
				coll.remove( s );
				break;
			}
		}





		if ( coll.contains( "Hello1" ) ) {
			coll.remove( "Hello1" );
		}





		Person p = new Person( "张一", 21 );
//		coll.add( p );
//		coll.add( 1 );

		System.out.println( "集合数据个数是:" + coll.size() );





		// 查找某个数据
		if ( coll.contains( "Hello1" ) ) {
			System.out.println( "集合中包含Hello1对象" );
			coll.remove( p );
		}
		System.out.println( "集合数据个数是:" + coll.size() );





		printColl( coll );




		Iterator iter = coll.iterator();
		System.out.println( iter );

		while ( iter.hasNext() ) {

			Object obj = iter.next();
			System.out.println( obj );
		}


	}

	public static void printColl( Collection< String > coll ) {

		for(String s : coll){

			System.out.println(s);
		}

		// 遍历集合里面的数据
		// coll.iterator()返回的是一个实现了Iterator接口的类的对象
		Iterator< String > it = coll.iterator();
		while ( it.hasNext() ) {

			String s = it.next();
			System.out.println( s );
		}

	}

}
