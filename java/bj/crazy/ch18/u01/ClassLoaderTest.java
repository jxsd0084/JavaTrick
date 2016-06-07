package bj.crazy.ch18.u01;

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

class Tester {

	static {

		System.out.println( "Tester类的静态初始化块..." );
	}

}

public class ClassLoaderTest {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws ClassNotFoundException {

		ClassLoader cl = ClassLoader.getSystemClassLoader();


		// 第一步: 下面语句仅仅是加载Tester类

		cl.loadClass( "bj.crazy.ch18.u01.Tester" );

		System.out.println( "系统加载Tester类" );



		// 第二步: 下面语句才会初始化Tester类

		Class.forName( "bj.crazy.ch18.u01.Tester" );





	}
}
