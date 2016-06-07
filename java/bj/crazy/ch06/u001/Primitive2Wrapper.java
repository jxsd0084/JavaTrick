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
public class Primitive2Wrapper {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		boolean bl = true;




		// 通过构造器把b1 基本类型 变量包装成 包装类 对象
		Boolean blObj = new Boolean( bl );





		int it = 5;
		// 通过构造器把it 基本类型 变量包装成 包装类 对象
		Integer itObj = new Integer( it );




		// 把一个 字符串 转换成 Float 对象
		Float fl = new Float( "4.56" );





		//把一个 字符串 转换成 Boolean 对象
		Boolean bObj = new Boolean( "trUe" );
		System.out.print( "---------" + bObj );





		// 下面程序运行时将出现 java.lang.NumberFormatException 异常
		// Long lObj = new Long("ddd");






		// 取出Boolean对象里的 boolean 变量
		boolean bb = bObj.booleanValue();





		// 取出Integer对象里的 int 变量
		int i = itObj.intValue();





		// 取出Float对象里的 float 变量
		float f = fl.floatValue();





	}

}
