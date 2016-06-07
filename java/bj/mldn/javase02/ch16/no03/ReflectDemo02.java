package bj.mldn.javase02.ch16.no03;

import java.lang.reflect.Method;

public class ReflectDemo02 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		Class< ? > c = null;
		c = Class.forName( "org.lxh.demo16.reflectannotation.SimpleBeanTwo" );
		Method toM = c.getMethod( "toString" );    // 找到toString()方法
		if ( toM.isAnnotationPresent( MyDefaultAnnotationReflect.class ) ) {
			// 判断是否是指定的Annotation
			MyDefaultAnnotationReflect mda = null;
			mda = toM.getAnnotation( MyDefaultAnnotationReflect.class );    // 得到指定的Annotation
			String key   = mda.key();    // 取出设置的key
			String value = mda.value();    // 取出设置的value
			System.out.println( "key = " + key );
			System.out.println( "value = " + value );
		}
	}
}
