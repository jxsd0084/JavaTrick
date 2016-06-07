package bj.mldn.javase02.ch04.no02;

public class MethodDemo01 {

	public static void main( String args[] ) {

		printInfo();        // 调用printInfo()方法
		printInfo();        // 调用printInfo()方法
		printInfo();        // 调用printInfo()方法
		System.out.println( "Hello World!!!" );
	}

	public static void printInfo() {

		// 定义字符数组
		char c[] = {
				'H', 'e', 'l', 'l',
				'o', ',', 'L', 'X', 'H'
		};


		for ( int x = 0; x < c.length; x++ ) {    // 循环输出
			System.out.print( c[ x ] );
		}
		System.out.println( "" );    // 换行
	}

}
