package bj.crazy.ch06.u007;

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
public class InnerNoStatic {

	private class InnerClass {

		/*

			下面三个静态声明都将引发如下 编译错误:

			非静态内部类不能有静态声明

		*/

		/*

			static
			{
				System.out.println("==========");
			}
			private static int inProp;
			private static void test(){};

		*/

	}

}
