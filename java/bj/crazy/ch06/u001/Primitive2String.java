package bj.crazy.ch06.u001;

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
public class Primitive2String {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {


		String intStr = "123";





		// 把一个 特定字符串 转换成 int 变量
		int it = Integer.parseInt( intStr );
		System.out.println( it );





		// 把一个 特定字符串 转换成 float 变量
		String floatStr = "4.56";
		float ft = Float.parseFloat( floatStr );
		System.out.println( ft );






		// 把一个 float 变量转换成 String 变量
		String ftStr = String.valueOf( 2.345f );

		System.out.println( ftStr );






		// 把一个 double 变量转换成 String 变量
		String dbStr = String.valueOf( 3.344 );

		System.out.println( dbStr );







		// 把一个 boolean 变量转换成 String 变量
		String boolStr = String.valueOf( true );

		System.out.println( boolStr.toUpperCase() );






	}
}
