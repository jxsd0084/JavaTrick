package bj.powernode.basic.day16.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*

	通过基因信息获取方法的基因片段

*/
public class GetMethodByClass {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		Class c = Class.forName( "com.dlpowernode.reflect.User" );

		// 1.获取所有的方法基因信息片段
		Method[] methods = c.getDeclaredMethods();

		// 2.一共多少个方法
		System.out.println( methods.length + "个方法" );

		// 3.遍历数组,操作每一个方法基因片段
		for ( int i = 0; i < methods.length; i++ ) {

			StringBuffer sb = new StringBuffer();

			// 获取修饰符
			String modifiers = Modifier.toString( methods[ i ].getModifiers() );


			// 方法的返回值类型
			Class  returnType     = methods[ i ].getReturnType();
			String returnTypeName = returnType.getSimpleName();

			// 获取方法名
			String methodName = methods[ i ].getName();

			sb.append( modifiers + " " + returnTypeName + " " + methodName + "(" );

			// 方法的形参
			Class[] parameterTypes = methods[ i ].getParameterTypes();

			for ( int k = 0; k < parameterTypes.length; k++ ) {

				String parameterTypeName = parameterTypes[ k ].getSimpleName();
				if ( k == parameterTypes.length - 1 ) {

					sb.append( parameterTypeName + " arg" + k + "" );
				} else {

					sb.append( parameterTypeName + " arg" + k + "," );
				}

			}

			sb.append( "){}" );

			System.out.println( sb.toString() );


		}


		Object obj = c.newInstance();

		// 重点：通过方法的基因片段对象调用方法.
		for ( Method m : methods ) {

			if ( "eat".equals( m.getName() ) ) {  // 调用eat方法   m 是eat方法的基因片段对象.
				
				/*
					 Object invoke(Object obj, Object... args) 
					 	1.invoke方法的obj参数是将来真正执行eat方法的对象.
					 	2.invoke方法的args参数是执行eat方法时需要的实参.
					 	3.invoke方法的返回值是eat方法的返回值. 
				*/

				Object exeResult = m.invoke( obj, "鱼香肉丝" );


				System.out.println( exeResult );


			}

			if ( "add".equals( m.getName() ) ) {

				Object result = m.invoke( obj, 10, 20, 30 );

				System.out.println( result );
			}

		}


	}


}
