package bj.powernode.basic.day16.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/*

	获取构造方法

*/
public class GetConstructorByClass {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// c是全部基因信息.
		Class c = Class.forName( "com.dlpowernode.reflect.User" );

		// 获取所有的构造方法的基因片段.
		Constructor[] constructors = c.getDeclaredConstructors();

		// 查看有多少个构造方法
		System.out.println( constructors.length + "个构造方法" );


		// 循环获取构造方法
		for ( Constructor cs : constructors ) {  // Constructor API

			StringBuffer sb = new StringBuffer();

			String modifiers             = Modifier.toString( cs.getModifiers() );  // 修饰符
			String constructorMethodName = c.getSimpleName();                       // 构造方法的名字

			sb.append( modifiers + " " + constructorMethodName + "(" );

			// 获得当前构造方法cs的 形参类型
			Class[] parameterTypes = cs.getParameterTypes();
		
			/*
				for(Class parameterType:parameterTypes){
					String parameterTypeName = parameterType.getSimpleName();
					sb.append(parameterTypeName+" arg0,");
				}
			*/

			for ( int i = 0; i < parameterTypes.length; i++ ) {

				String parameterTypeName = parameterTypes[ i ].getSimpleName();
				if ( i == parameterTypes.length - 1 ) {

					sb.append( parameterTypeName + " arg" + i );
				} else {

					sb.append( parameterTypeName + " arg" + i + "," );
				}

			}

			sb.append( "){}" );

			System.out.println( sb.toString() );
		}


		// 重点:通过构造方法的基因片段来创建对象.

		// 通过构造方法的基因片段对象动态创建User实例.


		// Constructor c1 = constructors[0];    // 第一个构造方法的基因片段
		// Object o1 = c1.newInstance();
		// System.out.println(o1);


		Constructor c2 = constructors[ 1 ];     // 第二个构造方法的基因片段
		Object      o2 = c2.newInstance( "jack", "jack@126.com", true );
		System.out.println( o2 );


	}

}
