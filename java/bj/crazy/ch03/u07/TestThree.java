package bj.crazy.ch03.u07;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TestThree {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 三目运算法
		String str = 5 > 3 ? "5大于3" : "5不大于3";

		System.out.println( str );




		String str2 = null;

		if ( 5 > 3 ) {
			str2 = "5大于3";

		} else {
			str2 = "5不大于3";
		}




	}

}
