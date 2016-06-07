package bj.powernode.basic.day16.getWholeClassInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
	必须掌握的内容：
		1.通过构造方法基因片段动态创建实例.
		2.通过方法的基因片段动态调用实例的方法.

*/
public class Test {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		StringBuffer sb = new StringBuffer();                                   // StringBuffer用来存储下列内容

		Class c = Class.forName( "com.dlpowernode.reflect.Person" );            // 获取整个类的基因信息

		Package p = c.getPackage();                                             // 获取package基因片段

		sb.append( p.toString() + ";\n\n" );

		String definationClassModifiers = Modifier.toString( c.getModifiers() );  // 获取类定义的修饰符

		String simpleClassName = c.getSimpleName();                               // 获取简单类名



		if ( c.isEnum() ) {
			sb.append( definationClassModifiers + " enum " + simpleClassName + "{\n\n" );

		} else if ( !c.isInterface() ) {
			sb.append( definationClassModifiers + " class " + simpleClassName + "{\n\n" );

		} else {
			sb.append( definationClassModifiers + " " + simpleClassName + "{\n\n" );
		}


		// 关于属性的操作
		Field[] fields = c.getDeclaredFields();                                     // 获取所有的属性基因片段

		for ( Field f : fields ) { // f是某一个属性基因片段

			String fieldModifiers = Modifier.toString( f.getModifiers() );

			String fieldTypeName = f.getType().getSimpleName();                     // 属性类型的简单名字

			String fieldName = f.getName();

			sb.append( "\t" + fieldModifiers + " " + fieldTypeName + " " + fieldName + ";\n\n" );

		}


		// 关于构造方法的操作
		Constructor[] cs                    = c.getDeclaredConstructors();
		String        constructorMethodName = c.getSimpleName();                    // 构造方法的名字

		for ( int i = 0; i < cs.length; i++ ) {                                     // cs[i] 代表某一个构造方法的基因片段

			String constructorModifiers = Modifier.toString( cs[ i ].getModifiers() );  // 修饰符

			sb.append( "\t" + constructorModifiers + " " + constructorMethodName + " (" );

			Class[] parameterTypes = cs[ i ].getParameterTypes();                    // 获取构造方法的形参类型

			for ( int j = 0; j < parameterTypes.length; j++ ) {

				if ( j == parameterTypes.length - 1 ) {
					sb.append( parameterTypes[ j ].getSimpleName() + " arg" + j );
				} else {
					sb.append( parameterTypes[ j ].getSimpleName() + " arg" + j + "," );
				}


			}

			sb.append( "){}\n\n" );

		}


		// 关于方法的操作

		Method[] methods = c.getDeclaredMethods();

		for ( Method m : methods ) {

			String methodModifiers = Modifier.toString( m.getModifiers() );     // 方法的修饰符

			String returnTypeName = m.getReturnType().getSimpleName();          // 方法返回值类型的简单名字.

			String methodName = m.getName();                                    // 方法名.

			sb.append( "\t" + methodModifiers + " " + returnTypeName + " " + methodName + "(" );

			Class[] parameterTypes = m.getParameterTypes();                     // 获取方法的形参类型

			for ( int j = 0; j < parameterTypes.length; j++ ) {

				if ( j == parameterTypes.length - 1 ) {
					sb.append( parameterTypes[ j ].getSimpleName() + " arg" + j );
				} else {
					sb.append( parameterTypes[ j ].getSimpleName() + " arg" + j + "," );
				}


			}

			sb.append( "){}\n\n" );

		}

		sb.append( "}" );


		System.out.println( sb.toString() );


	}

}
