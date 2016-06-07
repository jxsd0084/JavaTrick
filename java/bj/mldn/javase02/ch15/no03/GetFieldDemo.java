package bj.mldn.javase02.ch15.no03;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GetFieldDemo {

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
		{    // 本类属性
			Field f[] = c1.getDeclaredFields();    // 取得本类中的属性
			for ( int i = 0; i < f.length; i++ ) {
				Class< ? > r    = f[ i ].getType();    // 得到属性类型
				int        mo   = f[ i ].getModifiers();    // 得到修饰符的数字
				String     priv = Modifier.toString( mo ); // 还原修饰符
				System.out.print( "本类属性：" );
				System.out.print( priv + " " );
				System.out.print( r.getName() + " " );    // 得到属性类型
				System.out.print( f[ i ].getName() );    // 输出属性名称
				System.out.println( " ;" );
			}
		}
		{    // 公共属性
			Field f[] = c1.getFields();    // 取得本类中的公共属性
			for ( int i = 0; i < f.length; i++ ) {
				Class< ? > r    = f[ i ].getType();    // 得到属性类型
				int        mo   = f[ i ].getModifiers();    // 得到修饰符的数字
				String     priv = Modifier.toString( mo ); // 还原修饰符
				System.out.print( "公共属性：" );
				System.out.print( priv + " " );
				System.out.print( r.getName() + " " );    // 得到属性类型
				System.out.print( f[ i ].getName() );    // 输出属性名称
				System.out.println( " ;" );
			}
		}
	}
}
