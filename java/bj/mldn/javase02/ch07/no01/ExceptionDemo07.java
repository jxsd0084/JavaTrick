package bj.mldn.javase02.ch07.no01;

public class ExceptionDemo07 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		System.out.println( "********** 计算开始 ***********" );
		int i = 0;                           // 定义整型变量
		int j = 0;                           // 定义整型变量

		try {

			String str1 = args[ 0 ];         // 接收第一个参数
			String str2 = args[ 1 ];         // 接收第二个参数
			i = Integer.parseInt( str1 );    // 将第一个参数由字符串变为整型
			j = Integer.parseInt( str2 );    // 将第二个参数由字符串变为整型
			int temp = i / j;                // 此处产生了异常
			System.out.println( "两个数字相除的结果：" + temp );
			System.out.println( "----------------------------" );

//		} catch (Exception e) {
//			System.out.println("其他异常：" + e);
		} catch ( ArithmeticException e ) {  // 捕获算术异常
			// System.out.println("算术异常：" + e) ;
			e.printStackTrace();
		}

		System.out.println( "********** 计算结束 ***********" );
	}

}