package bj.mldn.javase02.ch15.no04;

import java.lang.reflect.Array;

public class ChangeArrayDemo {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) throws Exception {

		int temp[]    = { 1, 2, 3 };                    // 声明一整型数组
		int newTemp[] = (int[]) arrayInc( temp, 5 );    // 重新开辟空间5
		print( newTemp );
		System.out.println( "\n-------------------------" );
		String t[]  = { "lxh", "mldn", "mldnjava" };
		String nt[] = (String[]) arrayInc( t, 8 );
		print( nt );
	}

	public static Object arrayInc( Object obj, int len ) {

		Class< ? > c    = obj.getClass();
		Class< ? > arr  = c.getComponentType();    // 得到数组的
		Object     newO = Array.newInstance( arr, len );    // 开辟新的大小
		int        co   = Array.getLength( obj );
		System.arraycopy( obj, 0, newO, 0, co );    // 拷贝内容
		return newO;
	}

	public static void print( Object obj ) {    // 数组输出
		Class< ? > c = obj.getClass();
		if ( ! c.isArray() ) {    // 判断是否是数组
			return;
		}
		Class< ? > arr = c.getComponentType();
		System.out.println( arr.getName() + "数组的长度是：" + Array.getLength( obj ) );     // 输出数组信息
		for ( int i = 0; i < Array.getLength( obj ); i++ ) {
			System.out.print( Array.get( obj, i ) + "、" );    // 通过Array输出
		}
	}
}
