package bj.powernode.basic.day07;


/*
	
	数组动态创建.
	
	结论： 如果没有给数组的元素赋值,

			byte,short,int,long 类型的数组,每个元素都是 0

			boolean 类型的数组,每个元素都是 false

			double,float 类型的数组,每个元素都是 0.0

			char 类型的数组, 每个元素都是 '\u0000'

			引用类型的数组,每个都是 null
		
		
	如何给数组的某个元素赋值：

		例如给ints数组的第2个元素赋值为3 --> ints[1] = 3;

*/
public class _04_TestArray {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		int[] ints = new int[ 10 ];         // 初始化10个长度的int类型的数组.
		ints[ 0 ] = 9;
		ints[ 1 ] = 4;
		ints[ 7 ] = 5;

		for ( int i = 0; i < ints.length; i++ ) {

			System.out.print( ints[ i ] + " " );
		}
		System.out.println();

		Date[] dates = new Date[ 3 ];       // 初始化3个长度的Date类型的数组.
		dates[ 0 ] = new Date( 2010, 10, 1 );
		dates[ 1 ] = new Date( 2010, 11, 1 );
		dates[ 2 ] = new Date( 2010, 12, 1 );

		for ( int i = 0; i < dates.length; i++ ) {

			System.out.print( dates[ i ] + " " );
		}
		System.out.println();

		String[] strs = new String[ 4 ];    // 初始化4个长度的String类型的数组.
		strs[ 0 ] = "张三";
		strs[ 1 ] = "李四";
		strs[ 2 ] = "王五";
		strs[ 3 ] = "赵六";

		for ( int i = 0; i < strs.length; i++ ) {

			System.out.print( strs[ i ] + " " );
		}
		System.out.println();

		boolean[] bs = new boolean[ 2 ];    // 初始化2个长度的boolean类型的数组.
		bs[ 0 ] = true;
		bs[ 1 ] = false;

		for ( int i = 0; i < bs.length; i++ ) {

			System.out.print( bs[ i ] + " " );
		}

	}

}
