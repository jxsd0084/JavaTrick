package bj.crazy.ch04.u03;

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
public class TestForError {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {


		// 循环的初始化条件,循环条件，循环迭代语句都在下面一行
		for ( int count = 0; count < 10; count++ ) {

			System.out.println( count );

			// 再次修改了循环变量
			count *= 0.1;
		}

		System.out.println( "循环结束!" );



	}

}
