package bj.powernode.basic.day04;
/*
	注意:方法结束,为该方法分配的所有空间将被释放.
*/

//如何访问成员变量(属性/attrbute)

public class Lab03 {    //  创建类

	//  成员变量

	int i = 10;
	

		/*
		  JVM内存空间分配:

			Code segment (代码区域).

			data segment (数据:字符串常量+静态变量).

			stack (栈:局部变量).

			heap (堆：存放new出的对象和成员变量).
		*/


	//  静态变量
	static double d = 1.2;

	public static void main( String[] args ) {   // 主方法

		int k = 100;

		//  访问一个类的静态变量.

		System.out.println( Lab03.d );      //  类名.静态变量名
		System.out.println( d );


		//  访问一个对象的成员变量.

		Lab03 lab03 = new Lab03();          //  创建对象的时候,对象的成员变量会被初始化.

		System.out.println( lab03.i );      //  类名.成员变量名


		//  调用printInt方法.
		lab03.printInt( 456 );

	}

	//  创建printInt(int i){}方法
	void printInt( int i ) {

		System.out.println( i );
	}

	//  创建printInt(byte b){}方法
	void printByte( byte b ) {

		System.out.println( b );
	}

	//  创建printInt(double d){}方法
	void printDouble( double d ) {

		System.out.println( d );
	}

	//  创建printInt(String str){}方法
	void printStr( String str ) {

		System.out.println( str );
	}

}
