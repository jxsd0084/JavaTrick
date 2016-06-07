package bj.powernode.basic.day08.homework;

/**
 * 接收一组数据.
 * 排序输出(从小到大)
 */
public class HomeWork01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		//1.初始化一个int类型的数组.
		int[] ints = new int[ args.length ];

		for ( int i = 0; i < args.length; i++ ) {

			ints[ i ] = Integer.parseInt( args[ i ] );
		}


		//2.从小到大排序.(选择排序)

		int temp;

		for ( int i = 0; i < ints.length - 1; i++ ) {

			for ( int j = i + 1; j < ints.length; j++ ) {

				if ( ints[ i ] > ints[ j ] ) {

					temp = ints[ i ];
					ints[ i ] = ints[ j ];
					ints[ j ] = temp;
				}


			}

			//3.输出
			for ( int k = 0; k < ints.length; k++ ) {

				System.out.print( ints[ k ] + " " );
			}

		}

	}

}
