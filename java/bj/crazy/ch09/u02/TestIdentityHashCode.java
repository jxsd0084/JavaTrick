package bj.crazy.ch09.u02;

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
public class TestIdentityHashCode {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 下面程序中s1和s2是两个 不同 对象

		String s1 = new String( "Hello" );
		String s2 = new String( "Hello" );




		// String重写了hashCode方法——改为根据字符序列计算hashCode值，

		// 因为s1和s2的字符序列 相同，所以它们的hashCode方法返回值 相同

		System.out.println( "s1 vs v2 -> " + s1.hashCode() + "----" + s2.hashCode() );





		// s1和s2是 不同的 字符串对象，所以它们的identityHashCode值 不同

		System.out.println( "s1 vs v2 -> " + System.identityHashCode( s1 ) + "----" +
		                    System.identityHashCode( s2 ) );





		String s3 = "Java";
		String s4 = "Java";

		// s3和s4是 相同的 字符串对象，所以它们的identityHashCode值 相同
		System.out.println( "s3 vs v4 -> " + System.identityHashCode( s3 ) + "----" +
		                    System.identityHashCode( s4 ) );




	}

}
