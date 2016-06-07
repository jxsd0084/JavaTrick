package bj.czbk.day04;

class ArrayDemo3 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		//  数组的操作：
		//  获取数组中的元素。通常会用到遍历。

		//  int[] arr = new int[3];
		int[] arr = { 3, 6, 5, 1, 8, 9, 67 };

		//  数组中有一个属性可以直接获取到数组元素个数。length.
		//  使用方式：数组名称.length =
		//  System.out.println("length:"+arr.length);

		//  int sum = 0;
		/*
		for(int x=0; x<arr.length; x++) {
			//  sum += arr[x];
			System.out.println("arr["+x+"]="+arr[x]+";");//arr[0]=0;
		}
		*/

		//  System.out.println(arr);

		printArray( arr );
		//  printArray(arr);

	}

	//  定义功能，用于打印数组中的元素。元素间用逗号隔开。
	public static void printArray( int[] arr ) {

		System.out.print( "[" );
		for ( int x = 0; x < arr.length; x++ ) {
			if ( x != arr.length - 1 ) {
				System.out.print( arr[ x ] + ", " );
			} else {
				System.out.println( arr[ x ] + "]" );
			}
		}
	}

}
