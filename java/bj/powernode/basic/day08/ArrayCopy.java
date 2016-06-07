package bj.powernode.basic.day08;


/*

	使用java提供的类和方法完成数组的拷贝.
	
	int[] i1 = {1,2,3,4};  //拷贝源 src-->source
	
	int[] i2 = new int[5];  // {0,0,2,3,0}  //拷贝目标 dest
	
	期望结果: i2变成--> {0,1,2,3,4}

	前提：拷贝的数据具有连贯性.使用java的API可以提高效率	
	
	
	public static void arraycopy(
			     Object src, 拷贝源
                             int srcPos, src Position. 从拷贝源的第几个元素开始拷贝,例如,从第2个元素拷贝,就应该填写 1
                             Object dest,拷贝目标
                             int destPos,  从拷贝目标的第几个元素接收,例如,从拷贝目标的第3个元素接收,就应该写 2
                             int length  拷贝的长度.
                             )

*/
public class ArrayCopy {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		int[] i1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };  // 3,4,5,6

		int[] i2 = new int[ 15 ];                  // 从下标4开始接收

		System.arraycopy( i1, 2, i2, 4, 4 );

		for ( int i = 0; i < i2.length; i++ ) {

			System.out.print( i2[ i ] + " " );
		}

		// 出现异常.
		int[] i3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int[] i4 = new int[ 20 ];  //15 16 17 18 19

		// System.arraycopy(i3,0,i4,15,9);  // 最多接收5个，但是传递过来9个(数组下标越界异常. java.lang.ArrayIndexOutOfBoundsException.)

	}

}
