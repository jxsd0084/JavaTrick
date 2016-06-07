package bj.crazy.ch08.u04;

import java.util.*;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class Test {

	// 声明一个泛型方法，该泛型方法中带一个T形参

	// static <T> void test(Collection<T> a, Collection<T> c)

	static < T > void test( Collection< ? extends T > a, Collection< T > c ) {

		System.out.println("method test called...");

		int i = 0;
		for ( T o : a ) {

			i++;

			c.add( o );

			System.out.println( "-> " + i );
		}

	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		List< Object > ao = new ArrayList< Object >();

		List< String > as = new ArrayList< String >();


		// 下面代码将产生编译错误
		test( as, ao );


	}

}
