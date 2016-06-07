package bj.powernode.basic.day04;
/*
	方法的重载 (Over Load).
	
	方法的重载有什么作用？
		方便程序员的调用.
	
	
	注意：方法的重载发生在同一个类中.
	
	什么时候构成方法的重载？
		1.方法名一致.

		2.参数列表不同.
			什么时候参数列表不同？ 参数的类型不同,参数的个数不同.
	
	注意：如果方法只有返回值类型不同,那么这两个方法并没有构成重载.

*/


public class TestOverload {
	
	
	/*
		以下代码不使用方法的重载.

		不使用方法的重载,程序员需要记忆三个方法名.
	*/

	//  打印double类型的数据
	void printDouble( double d ) {

		System.out.println( d );
	}

	//  打印byte类型的数据.
	void printByte( byte b ) {

		System.out.println( b );
	}


	//  打印int类型的数据.
	void printInt( int i ) {

		System.out.println( i );
	}


	/*
		使用方法的重载.

		使用方法重载之后程序员只需要记忆一个方法就可以。
	*/
	void print( double d ) {

		System.out.println( d );
	}

	void print( int i ) {

		System.out.println( i );
	}

	//  没有构成方法的重载.
	//  int print(int i){
	//  	return 0;
	//  }


	void print( byte b ) {

		System.out.println( b );
	}


	//  程序的入口
	public static void main( String[] args ) {

	}


}


class MyTest {

	//  重载发生在同一个类体中.
	void print( String str ) {

		System.out.println( str );
	}

}
