package bj.powernode.basic.day03;

public class Lab01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		//  要想退出该软件,需要用户输入0.
		//  接收用户在键盘上的输入

		java.util.Scanner s = new java.util.Scanner( System.in );

		while ( true ) {

			int num = s.nextInt();  //  程序等待输入:用户输入100 ,那么num的值就是100

			if ( num == 0 ) {       //   退出

				return;
			}

			//  判断是否是偶数
			if ( num % 2 == 0 ) {
				System.out.println( num + "是偶数." );

			} else {
				System.out.println( num + "是奇数." );

			}

		}

	}

}
