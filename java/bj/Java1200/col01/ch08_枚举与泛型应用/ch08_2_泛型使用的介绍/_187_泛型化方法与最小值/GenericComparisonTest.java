package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._187_泛型化方法与最小值;

/**
 * 泛型化方法与最小值
 */
public class GenericComparisonTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		String[] books = { "Java从入门到精通（第2版）", "Java编程宝典", "细说Java", "视频学Java" };
		System.out.println( "明日科技新书列表：" );
		for ( String book : books ) {

			System.out.println( book );
		}

		String min = GenericComparison.getMin( books );
		System.out.println( "按名称排序的第一本书：" );
		System.out.println( min );

	}

}
