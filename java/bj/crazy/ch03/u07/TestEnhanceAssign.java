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
public class TestEnhanceAssign {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 定义一个 byte 类型的变量

		byte a = 5;






		// 下面语句出错，因为5默认是 int 类型，a + 5就是int类型。

		// 把int类型赋给byte类型的变量，所以出错。

		// a = a + 5;





		// 定义一个 byte 类型的变量
		byte b = 5;

		// 下面语句将不会出现错误
		b += 5;






	}

}
