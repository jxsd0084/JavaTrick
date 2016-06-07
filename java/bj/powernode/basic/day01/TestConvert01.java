package bj.powernode.basic.day01;

public class TestConvert01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		int    i1 = 123;
		int    i2 = 456;
		double d1 = ( i1 + i2 ) * 1.2;                  //  系统将转换成double型运算
		float  f1 = (float) ( ( i1 + i2 ) * 1.2 );      //  需要加强制类型转换符
		byte   b1 = 1;                                  //  为什么不需要强制类型转换?
		byte   b2 = 2;
		byte   b3 = (byte) ( b1 + b2 );                 //  系统将转换成int运行，需要强制转换





		double d2 = 1e200;
		float  f2 = (float) d2;                         //  产生溢出
		System.out.println( f2 );






		float f3 = 1.23f;                               //  必须加f
		long  l1 = 123;
		long  l2 = 30000000000L;                        //  必须加L
		float f  = l1 + l2 + f3;                        //  系统将转换为float运算
		long  l  = (long) f;                            //  强制类型转换会舍去小数部分，不是四舍五入





	}

}
