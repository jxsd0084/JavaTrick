package bj.powernode.basic.day08;
/*

	冒泡排序,选择排序 (排序算法)
	
	二分法查找.(查找算法)
	
		注意:一般的查找是建立在排序基础之上的.

*/

public class Find {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] agrs ) {

		// 1.最笨的查找方式,效率最低的查找方式.
		int[] ints = { 1, 2, 3, 4, 5, 300, 302, 303, 305, 310 };

		// 2.要求找出9这个数字的下标.
		for ( int i = 0; i < ints.length; i++ ) {

			if ( ints[ i ] == 302 ) {

				System.out.println( "302这个数字的下标=" + i );
			}
		}


		// 3.效率高一点
		// 数组中有500个元素,1000这个元素在最后一位上,要查找1000这个数字所在下标.
		// 找164
		int[] datas = { 101, 110, 115, 130, 135, 160, 164, 169, 186 };  //9个元素,(0-8)

	}

}
