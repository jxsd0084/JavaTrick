package bj.crazy.ch08.u03;

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
// 定义Shape的子类Circle
public class Circle extends Shape {

	// 实现画图方法，以打印字符串来模拟画图方法实现
	public void draw( Canvas c ) {

		System.out.println( "在画布" + c + "画一个圆" );
	}

}
