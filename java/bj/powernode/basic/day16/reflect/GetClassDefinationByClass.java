package bj.powernode.basic.day16.reflect;

import java.lang.reflect.Modifier;

/*

	获取类的定义

*/
public class GetClassDefinationByClass {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		StringBuffer classDefination = new StringBuffer();

		// 获取类的定义

		Class c = Class.forName( "com.dlpowernode.reflect.User" );


		// 1.获取修饰类的修饰符.
		/*

			public  1
			default 0
			final 16
			abstract 1024
			interface 1536
		
		*/
		int modifiers = c.getModifiers();

		String ms = Modifier.toString( modifiers );  // public

		classDefination.append( ms + " " );






		// 2. class 关键字

		if ( c.isEnum() ) {
			classDefination.append( "enum " );

		} else if ( !ms.contains( "interface" ) ) {
			classDefination.append( "class " );

		}


		// 3. 简单类名(不带包名)
		String simpleClassName = c.getSimpleName();

		classDefination.append( simpleClassName );

		System.out.println( classDefination.toString() + "{" );


	}


}
