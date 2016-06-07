package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._186_泛型方法与数据查询;

import java.util.List;

/**
 * 泛型方法与数据查询
 */
public class GenericQueryTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		String        sql  = "select * from books;";

		List< Books > list = GenericQuery.query( sql, Books.class );
		System.out.println( "明日科技新书：" );

		for ( Books books : list ) {

			System.out.println( books );
		}

	}

}
