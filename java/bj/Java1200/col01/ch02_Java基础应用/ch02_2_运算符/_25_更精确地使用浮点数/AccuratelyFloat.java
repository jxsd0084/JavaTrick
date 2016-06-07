package bj.Java1200.col01.ch02_Java基础应用.ch02_2_运算符._25_更精确地使用浮点数;

import java.math.BigDecimal;

/**
 * 025 更精确地使用浮点数
 */
public class AccuratelyFloat {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		double money  = 2;                              // 现有金额
		double price  = 1.1;                            // 商品价格
		double result = money - price;

		System.out.println( "非精确计算" );
		System.out.println( "剩余金额：" + result );     // 输出运算结果

		// 精确浮点数的解决方法
		BigDecimal money1  = new BigDecimal( "2" );     // 现有金额
		BigDecimal price1  = new BigDecimal( "1.1" );   // 商品单击
		BigDecimal result1 = money1.subtract( price1 );
		System.out.println( "精确计算" );
		System.out.println( "剩余金额：" + result1 );    // 输出精确结果

	}

}
