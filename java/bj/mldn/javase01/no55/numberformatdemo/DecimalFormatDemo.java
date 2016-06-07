package bj.mldn.javase01.no55.numberformatdemo;

import java.text.DecimalFormat;

class FormatDemo {

	public void format( String pattern, double value ) {     // 此方法专门用于格式化
		DecimalFormat format = new DecimalFormat( pattern ); // 指定操作的模板
		String        str    = format.format( value );// 转换操作
		System.out.println( "数字按照格式（" + pattern + "）的转换结果是：" + str );
	}
}

public class DecimalFormatDemo {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		FormatDemo format = new FormatDemo();

		format.format( "000,000.000", 23456.45 );
		format.format( "###,###.###", 23456.45 );
		format.format( "000,000.000￥", 23456.45 );
		format.format( "###,###.###￥", 23456.45 );
		format.format( "##.###%", 0.34567 );
		format.format( "00.###%", 0.034567 );

	}

}
