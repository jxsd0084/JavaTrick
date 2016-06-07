package bj.mldn.javase02.ch15.no04;

import java.lang.reflect.Field;

public class InvokeFieldDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) throws Exception {

		Class< ? > c1  = null;
		Object     obj = null;
		c1 = Class.forName( "org.lxh.demo15.Person" );    // 实例化Class对象
		obj = c1.newInstance();
		Field nameField = null;
		Field ageField  = null;
		nameField = c1.getDeclaredField( "name" );    // 取得name属性
		ageField = c1.getDeclaredField( "age" );    // 取得name属性
		nameField.setAccessible( true );    // 此属性对外部可见
		ageField.setAccessible( true );    // 此属性对外部可见
		nameField.set( obj, "李兴华" );    // 设置name属性内容
		ageField.set( obj, 30 );            // 设置age属性内容
		System.out.println( "姓名：" + nameField.get( obj ) );
		System.out.println( "年龄：" + ageField.get( obj ) );
	}
}
