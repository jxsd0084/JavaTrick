package bj.mldn.javase02.ch07.no02;

class MyException extends Exception {    // 自定义异常类，继承Exception类

	public MyException( String msg ) {

		super( msg );    // 调用Exception类中有一个参数的构造方法，传递错误信息
	}
}

public class DefaultException {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		try {
			throw new MyException( "自定义异常。" );     // 抛出异常
		} catch ( Exception e ) {
			System.out.println( e );
		}
	}
}
