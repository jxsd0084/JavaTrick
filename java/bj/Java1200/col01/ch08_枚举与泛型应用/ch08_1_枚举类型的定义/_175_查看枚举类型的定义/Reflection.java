package bj.Java1200.col01.ch08_枚举与泛型应用.ch08_1_枚举类型的定义._175_查看枚举类型的定义;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 查看枚举类型的定义
 */
public class Reflection {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Class< Position > enumClass = Position.class;
		String            modifiers = Modifier.toString( enumClass.getModifiers() );

		System.out.println( "enum类型的修饰符：" + modifiers );
		System.out.println( "enum类型的父类：" + enumClass.getSuperclass() );
		System.out.println( "enum类型的自定义方法：" );

		Method[] methods = enumClass.getDeclaredMethods();
		for ( Method method : methods ) {
			System.out.println( method );
		}
	}

}
