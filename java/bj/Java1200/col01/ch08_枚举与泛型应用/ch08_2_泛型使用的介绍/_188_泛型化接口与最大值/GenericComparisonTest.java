package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_2_泛型使用的介绍._188_泛型化接口与最大值;

/**
 * 泛型化接口与最大值
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
		GenericComparison< String > gc  = new GenericComparison< String >();
		String                      max = gc.getMax( books );
		System.out.println( "按名称排序最后一本书：" );
		System.out.println( max );
	}

}
