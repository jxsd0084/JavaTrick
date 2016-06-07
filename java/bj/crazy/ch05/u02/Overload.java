package bj.crazy.ch05.u02;

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
public class Overload {

	// 下面定义了2个test方法，但方法的形参列表不同

	// 系统可以区分这两个方法，这种被称为方法重载
	public void test() {

		System.out.println( "无参数" );
	}

	public void test( String msg ) {

		System.out.println( "重载的test方法 " + msg );
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Overload ol = new Overload();

		// 调用test时没有传入参数，因此系统调用上面没有参数的test方法。
		ol.test();

		// 调用test时传入了一个字符串参数，因此系统调用上面有一个字符串参数的test方法。
		ol.test( "hello" );

	}

}
