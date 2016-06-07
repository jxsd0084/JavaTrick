package bj.crazy.ch06.u001;

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
public class AutoBoxingUnboxing {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 直接把一个 基本类型 变量赋给 Integer 对象
		Integer inObj = 5;

		// 直接把一个 boolean 类型变量赋给一个 Object 类型的变量
		Object boolObj = true;





		// 直接把一个 Integer 对象赋给 int 类型的变量
		int it = inObj;
		if ( boolObj instanceof Boolean ) {

			// 先把 Object 对象强制类型转换为 Boolean 类型，再赋给 boolean 变量
			boolean b = (Boolean) boolObj;

			System.out.println( b );
		}




	}

}
