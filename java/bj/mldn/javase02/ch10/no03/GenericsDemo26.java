package bj.mldn.javase02.ch10.no03;

class Demo {

	public < T > T fun( T t ) {           // 可以接收任意类型的数据
		return t;                         // 直接把参数返回
	}
}

public class GenericsDemo26 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Demo   d   = new Demo();          // 实例化Demo对象
		String str = d.fun( "李兴华" );    // 传递字符串
		int    i   = d.fun( 30 );         // 传递数字，自动装箱
		System.out.println( str );        // 输出内容
		System.out.println( i );          // 输出内容
	}
}
