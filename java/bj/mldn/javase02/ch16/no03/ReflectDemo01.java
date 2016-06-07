package bj.mldn.javase02.ch16.no03;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectDemo01 {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		Class< ? > c = null;
		c = Class.forName( "org.lxh.demo16.reflectannotation.SimpleBeanOne" );
		Method     toM  = c.getMethod( "toString" );    // 找到toString()方法
		Annotation an[] = toM.getAnnotations();    // 取得全部的Annotation
		for ( Annotation a : an ) {    // 使用 foreach输出
			System.out.println( a );
		}
	}
}
