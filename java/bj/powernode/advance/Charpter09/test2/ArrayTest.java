package bj.powernode.advance.Charpter09.test2;

public class ArrayTest {

	/**
	 * 测试
	 */
	public static void main( String[] args ) {
		// 动态初始化数组
		// 声明,创建
		// int[] arr = new int[10];
		//		
		// // 初始化
		// for (int i = 0; i < arr.length; i++) {
		// arr[i] = 10 + i;
		// }

		// 静态态初始化数组,把数组的声明,创建,初始化合并到一起
		// int [] arr = {1,2,3,4,5,6,7,8,9,10};
		//		
		// printArr(arr);

		// 引用类型的数组,数组中的每个元素是个指向该类型对象的引用
		// 静态初始化引用类型的数组
		Person[] arr = { new Person( "张一", 21 ), new Person( "张二", 22 ),
				new Person( "张三", 23 ), new Person( "张四", 24 ) };
		printArr( arr );
	}

	public static void printArr( Person[] arr ) {
		for ( int i = 0; i < arr.length; i++ ) {
			System.out.println( "arr[" + i + "]=" + arr[ i ] );
		}

		System.out.println( "=============================" );

		// 依次取出arr数组中的每个元素(是个Person类型的引用),赋值给Person类型的引用p
		for ( Person p : arr ) {
			System.out.println( p );
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
