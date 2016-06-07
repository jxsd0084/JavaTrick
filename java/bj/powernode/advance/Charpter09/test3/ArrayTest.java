package bj.powernode.advance.Charpter09.test3;

public class ArrayTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		int[] arr = { 1, 2, 3, 4, 5 };

		// 数组也是一种引用类型,在传递的时候,传递的是地址,改变一个变量的值,会影响另外的变量
		// int[] arr1 = arr;
		change( arr );

		printArr( arr );
	}

	public static void change( int[] arr ) {
		for ( int i = 0; i < arr.length; i++ ) {
			arr[ i ] = 0;
		}
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

}
