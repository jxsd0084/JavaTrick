package bj.powernode.basic.day16.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*

	获取类的属性

*/
public class GetPropertyByClass {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		Class c = Class.forName( "com.dlpowernode.reflect.User" );





		// 1.获取所有的属性(公开的)
		Field[] fields = c.getFields();         // java.lang.reflect.Field; 属性基因片段

		System.out.println( fields.length );    // 1






		// 2.关注Field API

		Field f = fields[ 0 ];

		System.out.println( f.getName() );      // getFields()方法只能获取public的.

		System.out.println( "========================" );






		// 3.获取所有的属性(public default private protected)
		Field[] fs = c.getDeclaredFields();

		System.out.println( fs.length );

		for ( Field f1 : fs ) {

			String modifiers = Modifier.toString( f1.getModifiers() );

			Class  type     = f1.getType();      // 获得类型的基因信息
			String typeName = type.getSimpleName();

			String fieldName = f1.getName();

			if ( modifiers.length() == 0 ) {
				System.out.println( typeName + " " + fieldName + ";" );

			} else {
				System.out.println( modifiers + " " + typeName + " " + fieldName + ";" );

			}


		}

	}

}
