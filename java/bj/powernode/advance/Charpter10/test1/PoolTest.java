package bj.powernode.advance.Charpter10.test1;

public class PoolTest {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {

		// 在进行自动装箱的时候(除了浮点型之外),剩下的基本类型在一定的范围内(-128 - 127)在池中创建对象
		int     i  = - 129;
		Integer I1 = i;
		Integer I2 = i;

		byte b  = - 128;
		Byte I3 = b;
		Byte I4 = b;




		// char 类型在(0-127)范围内在池中分配
		char      c  = 0;
		Character c1 = c;
		Character c2 = c;





		// 所有的Boolean对象都在池中
		boolean b1 = true;
		Boolean c3 = b1;
		Boolean c4 = b1;

		System.out.println( c3 == c4 );




		// 浮点型数据在自动装箱的时候,没有池
		float f  = 3.4f;
		Float F1 = f;
		Float F2 = f;

		System.out.println( F1 == F2 );




		double f1 = 3.4;
		Double F3 = f1;
		Double F4 = f1;
		System.out.println( F3 == F4 );


	}

}
