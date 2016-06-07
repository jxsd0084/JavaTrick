package bj.mldn.javase02.ch07.no01;

public class ExceptionDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		System.out.println( "********** 计算开始 ***********" );
		int i = 10;             // 定义整型变量
		int j = 0;              // 定义整型变量

		try {

			int temp = i / j;   // 此处产生了异常
			System.out.println( "两个数字相除的结果：" + temp );
			System.out.println( "----------------------------" );

		} catch ( ArithmeticException e ) {    // 捕获算术异常
			System.out.println( "出现异常了：" + e );
		} finally {    // 作为异常的统一出口
			System.out.println( "不管是否出现异常，都执行此代码" );
		}
		System.out.println( "********** 计算结束 ***********" );
	}

}
