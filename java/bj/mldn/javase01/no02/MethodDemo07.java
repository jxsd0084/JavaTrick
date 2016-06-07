package bj.mldn.javase01.no02;

public class MethodDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		int sum = 0;
		for ( int i = 0; i <= 100; i++ ) {

			sum += i;    // 累加操作
		}
		System.out.println( "计算结果：" + sum );
	}

}
