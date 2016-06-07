package bj.mldn.javase02.ch15.no03;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetMethodDemo {

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
		Method m[] = c1.getMethods();    // 取得全部方法
		for ( int i = 0; i < m.length; i++ ) {
			Class< ? > r   = m[ i ].getReturnType();    // 得到返回值类型
			Class< ? > p[] = m[ i ].getParameterTypes();    // 取得全部参数的类型
			int        xx  = m[ i ].getModifiers();    // 得到修饰符
			System.out.print( Modifier.toString( xx ) + " " );    // 输出修饰符
			System.out.print( r + " " );
			System.out.print( m[ i ].getName() );
			System.out.print( "(" );
			for ( int j = 0; j < p.length; j++ ) {
				System.out.print( p[ j ].getName() + " " + "arg" + j );
				if ( j < p.length - 1 ) {
					System.out.print( "," );
				}
			}
			Class< ? > ex[] = m[ i ].getExceptionTypes();    // 取出异常
			if ( ex.length > 0 ) {
				System.out.print( ") throws " );
			} else {
				System.out.print( ")" );
			}
			for ( int j = 0; j < ex.length; j++ ) {
				System.out.print( ex[ j ].getName() );
				if ( j < p.length - 1 ) {
					System.out.print( "," );
				}
			}
			System.out.println();
		}
	}
}
