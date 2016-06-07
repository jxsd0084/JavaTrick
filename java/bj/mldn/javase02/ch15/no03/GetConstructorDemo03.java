package bj.mldn.javase02.ch15.no03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class GetConstructorDemo03 {

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
			Class< ? > p[] = con[ i ].getParameterTypes();        // 得到构造方法中的全部参数
			System.out.print( "构造方法：" );     // 输出构造，直接打印
			int mo = con[ i ].getModifiers(); // 得到所要的访问权限
			System.out.print( Modifier.toString( mo ) + " " );    // 得到修饰符
			System.out.print( con[ i ].getName() );    // 取得构造方法的名字
			System.out.print( "(" );
			for ( int j = 0; j < p.length; j++ ) {
				System.out.print( p[ j ].getName() + " arg" + i );
				if ( j < p.length - 1 ) {
					// 判断此是否是最后一个参数
					System.out.print( "," );    // 输出“,”
				}
			}
			System.out.println( "){}" );
		}
	}
}
