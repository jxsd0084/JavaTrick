package bj.crazy.ch05.u09;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class TestStaticInit {

	// 先执行静态初始化块将a属性赋值为 6
	static {
		a = 6;
	}

	// 再执行将静态属性a赋值为 9
	static int a = 9;

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 下面代码将输出 9 。
		System.out.println( TestStaticInit.a );

	}

}

