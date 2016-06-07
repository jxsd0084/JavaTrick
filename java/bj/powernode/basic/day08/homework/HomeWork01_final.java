package bj.powernode.basic.day08.homework;

/**
 * 接收一组数据.
 * 排序输出(从小到大)
 */
public class HomeWork01_final {

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
		int k              = - 1;
		int previousResult = 0;
		int count          = 0;

		for ( int i = 0; i < ints.length - 1; i++ ) {

			for ( int j = i + 1; j < ints.length; j++ ) {

				if ( ints[ i ] > ints[ j ] ) {

					if ( ++ count == 1 ) {

						previousResult = ints[ i ] - ints[ j ];
						k = j;

					} else {

						if ( previousResult < ints[ i ] - ints[ j ] ) {

							k = j;
							previousResult = ints[ i ] - ints[ j ];
						}
					}


				}
			}

			count = 0;

			if ( k != - 1 ) {  // k 是最小值的下标

				temp = ints[ i ];
				ints[ i ] = ints[ k ];
				ints[ k ] = temp;

				k = - 1;
			}


		}


		//3.输出
		for ( int i = 0; i < ints.length; i++ ) {

			System.out.print( ints[ i ] + " " );
		}


	}

}
