package bj.mldn.javase02.ch15.no04;

import java.lang.reflect.Method;

public class InvokeSetGetDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Class< ? > c1  = null;
		Object     obj = null;
		try {
			c1 = Class.forName( "org.lxh.demo15.Person" );    // 实例化Class对象
		} catch ( Exception e ) {
		}
		try {
			obj = c1.newInstance();
		} catch ( Exception e ) {
		}
		setter( obj, "name", "李兴华", String.class );    // 调用setter方法
		setter( obj, "age", 30, int.class );    // 调用setter方法
		System.out.print( "姓名：" );
		getter( obj, "name" );
		System.out.print( "年龄：" );
		getter( obj, "age" );
	}

	/**
	 * Object obj：要操作的对象
	 * String att：要操作的属性
	 * Object value：要设置的属性内容
	 * Class<?> type：要设置的属性类型
	 */
	public static void setter( Object obj, String att, Object value, Class< ? > type ) {

		try {
			Method met = obj.getClass().getMethod( "set" + initStr( att ), type );    // 得到setter方法
			met.invoke( obj, value );    // 设置setter的内容
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public static void getter( Object obj, String att ) {

		try {
			Method met = obj.getClass().getMethod( "get" + initStr( att ) );    // 得到setter方法
			System.out.println( met.invoke( obj ) );    // 调用getter取得内容
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public static String initStr( String old ) {    // 将单词的首字母大写
		String str = old.substring( 0, 1 ).toUpperCase() + old.substring( 1 );
		return str;
	}
}
