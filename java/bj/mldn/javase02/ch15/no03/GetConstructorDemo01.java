package bj.mldn.javase02.ch15.no03;

import java.lang.reflect.Constructor;

public class GetConstructorDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Class< ? > c1 = null;        // 声明Class对象
		try {
			c1 = Class.forName( "org.lxh.demo15.Person" );    // 实例化对象
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		Constructor< ? > con[] = c1.getConstructors();    // 取得一个类中的全部构造
		for ( int i = 0; i < con.length; i++ ) {
			System.out.println( "构造方法：" + con[ i ] );     // 输出构造，直接打印
		}
	}
}
