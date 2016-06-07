package bj.Java1200.col01.ch10_Commons组件.ch10_1_CommonsLang组件简介._217;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

/**
 * 数组元素的删除
 */
public class ArrayUtilsTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		int[] array0 = { 1, 2, 3, 2, 1 };// 在定义数组时实现初始化
		System.out.println( "数组中的元素是：" );
		System.out.println( Arrays.toString( array0 ) );// 输出数组中的全部元素
		System.out.println( "删除最后一个元素" );

		int[] array1 = ArrayUtils.remove( array0, 4 );// 删除索引为4的元素
		System.out.println( "数组中的元素是：" );
		System.out.println( Arrays.toString( array1 ) );// 输出新数组中的全部元素
		System.out.println( "删除元素2" );

		int[] array2 = ArrayUtils.removeElement( array0, 2 );// 删除元素2
		System.out.println( "数组中的元素是：" );
		System.out.println( Arrays.toString( array2 ) );// 输出新数组中的全部元素

	}

}
