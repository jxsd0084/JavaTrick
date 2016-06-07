package bj.powernode.basic.day09;

/*

	JDK 5.0 之后,出现了自动封箱 和 自动解箱.
	如果用eclipse做开发，要想使用自动封箱和自动解箱功能，必须保证编译器的版本在5.0之后(包括5.0)

*/

public class TestInteger2 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		int i1 = 10;

		Integer i2 = 10;                // 自动封箱

		int i3 = i2;                    // 自动解箱

		Integer i4 = 100;               // 自动封箱
		Integer i5 = 100;

		System.out.println( i4 + i5 );  // 自动解箱 200

	}

}
