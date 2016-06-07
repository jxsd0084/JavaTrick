package bj.mldn.javase02.ch04.no02;

public class MethodDemo02 {

	public static void main( String args[] ) {

		int   one = addOne( 10, 20 );        // 调用整型的加法操作
		float two = addTwo( 10.3f, 13.3f );  // 调用浮点数的加法操作
		System.out.println( "addOne的计算结果：" + one );
		System.out.println( "addTwo的计算结果：" + two );
	}

	// 定义方法，完成两个数字的相加操作，方法返回一个int型数据
	public static int addOne( int x, int y ) {

		int temp = 0;          // 方法中的参数，是局部变量
		temp = x + y;          // 执行加法计算
		return temp;           // 返回计算结果
	}

	// 定义方法，完成两个数字的相加操作，方法的返回值是一个float型数据
	public static float addTwo( float x, float y ) {

		float temp = 0;        // 方法中的参数，是局部变量
		temp = x + y;          // 执行加法操作
		return temp;           // 返回计算结果
	}

}
