package bj.Java1200.col01.ch07_反射与异常处理.ch07_2_反射的进阶._159;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 创建长度可变的数组
 */
public class UsefulArray {

	public static Object increaseArray( Object array ) {

		Class< ? > clazz = array.getClass();// 获得代表数组的Class对象
		if ( clazz.isArray() ) {// 如果输入是一个数组
			Class< ? > componentType = clazz.getComponentType();// 获得数组元素的类型
			int        length        = Array.getLength( array );// 获得输入的数组的长度
			Object     newArray      = Array.newInstance( componentType, length + 5 );// 新建数组
			System.arraycopy( array, 0, newArray, 0, length );// 复制原来数组中的所有数据
			return newArray;// 返回新建数组
		}
		return null;// 如果输入的不是数组就返回空
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		int[] intArray = new int[ 10 ];
		System.out.println( "整型数组原始长度是：" + intArray.length );
		Arrays.fill( intArray, 8 );
		System.out.println( "整型数组的内容：" );
		System.out.println( Arrays.toString( intArray ) );
		int[] newIntArray = (int[]) increaseArray( intArray );
		System.out.println( "整型数组扩展后长度是：" + newIntArray.length );
		System.out.println( "整型数组的内容：" );
		System.out.println( Arrays.toString( newIntArray ) );
	}

}
