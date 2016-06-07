package bj.mldn.javase02.ch07.no02;

class Math {

	public int div( int i, int j ) throws Exception {    // 定义除法操作，如果有异常，则交给被调用处处理
		System.out.println( "***** 计算开始 *****" );
		int temp = 0;    // 定义局部变量
		try {
			temp = i / j;    // 计算，但是此处有可能出现异常
		} catch ( Exception e ) {
			throw e;
		} finally {    // 不管是否有异常，都要执行统一出口
			System.out.println( "***** 计算结束 *****" );
		}
		return temp;
	}
}

public class ThrowDemo02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Math m = new Math();
		try {
			System.out.println( "除法操作：" + m.div( 10, 0 ) );
		} catch ( Exception e ) {
			System.out.println( "异常产生：" + e );
		}
	}
}
