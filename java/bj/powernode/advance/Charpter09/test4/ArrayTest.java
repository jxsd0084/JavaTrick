package bj.powernode.advance.Charpter09.test4;

public class ArrayTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		arr = reverse( arr );
		printArr( arr );
	}

	public static void printArr( int[] arr ) {
		// for(int i =0;i< arr.length;i++){
		// System.out.println("arr[" + i + "]=" + arr[i]);
		// }

		// 依次取出数组中的每个元素(是个int类的数据),赋值给相应的int 类型的变量i
		for ( int i : arr ) {
			System.out.println( i );
		}
	}

	/**
	 * 在新开数组的情况下,将数组里面的元素倒序排列
	 *
	 * @param arr
	 */
	public static int[] reverse( int[] arr ) {
		// 根据参数数组的长度,新建一个数组对象
		int[] temp = new int[ arr.length ];
		for ( int i = 0, j = temp.length - 1; i < arr.length; i++, j-- ) {
			temp[ j ] = arr[ i ];
		}
		// arr = temp;
		return temp;
	}
}
