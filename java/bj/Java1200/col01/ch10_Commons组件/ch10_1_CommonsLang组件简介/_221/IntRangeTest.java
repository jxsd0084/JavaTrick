package bj.Java1200.col01.ch10_Commons组件.ch10_1_CommonsLang组件简介._221;

import org.apache.commons.lang.math.IntRange;

import java.util.Arrays;

/**
 * 整数取值范围的判断
 */
public class IntRangeTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		IntRange range = new IntRange( - 5, 5 );// 创建一个从-5到5的区间

		System.out.println( "区间中的全部整数是：" );
		System.out.println( Arrays.toString( range.toArray() ) );// 输出区间中的全部整数

		System.out.print( "0是否在区间中：" );
		System.out.println( range.containsInteger( 0 ) );// 判断0是否在区间中

		System.out.print( "区间的上限是：" );
		System.out.println( range.getMaximumInteger() );// 输出区间的上限

		System.out.print( "区间的下限是：" );
		System.out.println( range.getMinimumInteger() );// 输出区间的下限

		System.out.print( "区间的字符串表示是：" );
		System.out.println( range.toString() );// 输出区间的数学表示形式

	}

}
