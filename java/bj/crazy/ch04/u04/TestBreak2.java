package bj.crazy.ch04.u04;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TestBreak2 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 外层循环
		outer:

		for ( int i = 0; i < 5; i++ ) {

			// 内层循环
			for ( int j = 0; j < 3; j++ ) {

				System.out.println( "i的值为:" + i + "  j的值为:" + j );
				if ( j == 1 ) {

					// 跳出 outer标签 所指定的循环。
					break outer;
				}
			}
		}


	}

}
