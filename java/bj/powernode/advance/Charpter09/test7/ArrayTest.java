package bj.powernode.advance.Charpter09.test7;

public class ArrayTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		// 数组引用类型
		// int[] a1 = { 1, 2, 3, 5, 6, 7 };
		// int[] a2 = { 4, 5, 6 };

		// 多维数组(数组的数组)
		// 二维数组,在第一维的数组中,有几个元素(在下面的例子中,第一维有两个元素,每个元素都是一个指向一个普通的数组对象的引用)
		// 在第二维数组中,数组中的每个元素就是一个基本类型值
		// int[][] arr = new int[2][3];

		// 在声明二维数组的时候,第二维的长度可以不用声明
		// int[][] arr = new int[2][];
		// 错误的声明方法
		// int[][] arr = new int[][3];
		// arr[0] = a1;
		// arr[1] = a2;
		//
		// printArr(arr);

		// 静态初始化基本类型的二维数组
		// int[][] arr = { { 1, 2, 3 }, { 3, 4, 5, 6, 7, 8, 9 }, { 3, 4, 5, 6 }
		// };

		// 引用类型也可以声明多维数组
		// 在第二维数组中,数组中的每个元素是个Person类型的引用

		/*
		 * Person[] a1 = { new Person("张一", 21), new Person("张2", 22) };
		 * Person[] a2 = { new Person("张三", 23), new Person("张4", 24), new
		 * Person("张5", 25) };
		 * 
		 * // 在引用类型的二维数组中,第一维数组中的每个元素是一个指向一个普通的引用类型数组的引用 //
		 * 在引用类型的二维数组中,第二维数组中的每个元素是一个指向Person对象的引用 Person[][] arr = new
		 * Person[2][]; arr[0] = a1; arr[1] = a2;
		 * 
		 * printArr(arr);
		 */

		// 静态初始化引用类型的二维数组
		// Person[][] arr = {
		// { new Person("张一", 21), new Person("张二", 22) },
		// { new Person("张三", 23), new Person("张4", 24),new Person("张五", 22) }
		// };
		//		
		//		
		// printArr(arr);
		// Person [][][][][] arr = new Person[3][][][][];

	}

	public static void printArr( Person[][] arr ) {
		for ( Person[] a : arr ) {
			for ( Person p : a ) {
				System.out.println( p );
			}
			System.out.println( "-----------------" );
		}

		for ( int i = 0; i < arr.length; i++ ) {
			for ( int j = 0; j < arr[ i ].length; j++ ) {
				Person p = arr[ i ][ j ];
				System.out.println( p );
			}
		}
	}

	public static void printArr( int[][] arr ) {
		for ( int[] a : arr ) {
			for ( int i : a ) {
				System.out.println( i );
			}
			System.out.println( "===============" );
		}

		System.out.println( "=======普通的for循环========" );

		for ( int i = 0; i < arr.length; i++ ) {
			for ( int j = 0; j < arr[ i ].length; j++ ) {
				System.out.println( "arr[" + i + "][" + j + "]=" + arr[ i ][ j ] );
			}
		}
	}
}
