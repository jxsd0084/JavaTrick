package bj.powernode.advance.Charpter09.test5;

public class ArrayCopyTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		int[] arr  = { 1, 2, 3, 4, 5 };
		int[] arr1 = new int[ 20 ];

         /*
         public static void arraycopy(Object src,
                             int srcPos,
                             Object dest,
                             int destPos,
                             int length) 
          */

		System.arraycopy( arr, 0, arr1, 0, arr.length );
		System.out.println( "000" );
	}
}
