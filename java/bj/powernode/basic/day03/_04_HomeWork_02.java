package bj.powernode.basic.day03;

public class _04_HomeWork_02 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		//  1-10的阶乘的求和.

		int k = 1;  //  初始化一个上一个数的阶乘为 1

		int sum = 0;

		for ( int i = 1; i <= 10; i++ ) {

			//  计算当前i的阶乘.
			//  i*(上一个数的阶乘)

			k = i * k;

			sum += k;

			System.out.println( i + "的阶乘是=" + k );
		}

		System.out.println( "1-10的阶乘的和:" + sum );
	}

}
