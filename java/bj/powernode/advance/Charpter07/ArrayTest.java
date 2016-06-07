package bj.powernode.advance.Charpter07;

public class ArrayTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		String[] arr1;
		Person[] ps;

		// 声明了一个数组的引用,该数组对象中只能存放int类型
		// int arr [];

		// 在声明数组引用的时候,不需要指明长度
		// 新创建的int数组对象,数组中的每个元素会被初始化成0

		// 基本类型的数组,数组中的每个元素是:是个基本类型数据的值
		int[] arr = new int[ 10 ];

		for ( int i = 0; i < arr.length; i++ ) {
			//System.out.println("arr[" + i + "]=" + arr[i]);
			arr[ i ] = ( 10 + i );
		}

		printArray( arr );

		// 声明数组的长度的时候,可以使用变量
		int   length = 100;
		int[] arr2   = new int[ length ];

		for ( int i = 0; i < arr2.length; i++ ) {
			arr2[ i ] = ( 10 + i );
		}

		printArray( arr2 );

		// 对于引用类型的数组,数组对象创建好之后,数组中的每个元素是个null
		Person[] p = new Person[ 4 ];

		// printArray(p);

		Person p1 = new Person( 21, "张1" );
		Person p2 = new Person( 22, "张2" );
		Person p3 = new Person( 23, "张3" );
		Person p4 = new Person( 24, "张4" );

		// 对引用类型的数组赋值之后,数组中的每个元素是个指向Person对象的Person类型引用
		// 将对象添加进数组内
		p[ 0 ] = p1;
		p[ 1 ] = p2;
		p[ 2 ] = p3;
		p[ 3 ] = p4;

		printArray( p );

	}

	public static void printArray( Person[] arr ) {

		for ( int i = 0; i < arr.length; i++ ) {

			System.out.println( "arr[" + i + "]=" + arr[ i ] );
		}
	}

	public static void printArray( int[] arr ) {

		for ( int i = 0; i < arr.length; i++ ) {

			System.out.println( "arr[" + i + "]=" + arr[ i ] );
		}
	}
}
