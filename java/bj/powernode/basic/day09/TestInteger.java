package bj.powernode.basic.day09;
/*
	
	java.lang.Integer
	

*/

public class TestInteger {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		//1.访问Integer的常量.
		System.out.println( "byte的最大值" + Byte.MAX_VALUE );
		System.out.println( "byte的最小值" + Byte.MIN_VALUE );
		System.out.println( "int的最大值" + Integer.MAX_VALUE );
		System.out.println( "int的最小值" + Integer.MIN_VALUE );




		//2.如何去创建一个Integer类型的对象.构造方法.
		Integer i1 = new Integer( 100 );
		Integer i2 = new Integer( "100" );

		System.out.println( i1.toString() ); //100
		System.out.println( i2.toString() ); //100





		//3.常用方法.

		//3.1 被封装数据的类型转换.
		byte b1 = i1.byteValue();
		long l1 = i1.longValue();
		System.out.println( b1 );
		System.out.println( l1 );





		//3.2 将字符串的数字转换成 数字类型的数据.
		int i3 = Integer.parseInt( "123" );
		int i4 = Integer.parseInt( "100" );
		System.out.println( i3 + i4 ); //223

		double d1 = Double.parseDouble( "1.2" );
		double d2 = Double.parseDouble( "4.5" );
		System.out.println( d1 + d2 ); //5.7






		//3.3 转换成二进制
		String binaryStr = Integer.toBinaryString( 2 );
		System.out.println( binaryStr ); //10





		//3.4 转换成十六进制
		String hexStr = Integer.toHexString( 15 );
		System.out.println( hexStr ); //f





		//3.5 转换八进制
		String oStr = Integer.toOctalString( 9 );
		System.out.println( oStr ); //11





		//3.6 "123" --> Integer类型.
		Integer i5 = Integer.valueOf( "123" );
		int     i6 = i5.intValue();
		System.out.println( i6 + 7 ); //130






	}

}
