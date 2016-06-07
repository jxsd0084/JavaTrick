package bj.mldn.javase02.ch12.no10;

import java.util.*;

public class TestInput {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) throws Exception {

		InputData input = new InputData();
		// float f = input.getFloat("请输入小数：","输入的不是小数，请重新输入！") ;
		// System.out.println("小数：" + f) ;
		Date d = input.getDate( "请输入日期，格式为（yyyy-mm-dd）：", "输入的日期格式不正确，请重新输入" );
		System.out.println( "日期" + d );
	}
}
