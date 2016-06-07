package bj.mldn.javase02.ch08.no02;

public class ProtectedDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		HelloDemo sub = new HelloDemo();
		System.out.println( sub.name );    // 错误的，不同包的类无法访问
	}
}
