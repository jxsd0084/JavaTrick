package bj.powernode.basic.day06;

public class _04_TestAccess extends _02_TestAccess {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		_04_TestAccess t = new _04_TestAccess();

		System.out.println( t.i3 );  // 在子类中访问protected修饰的变量  子类对象可以访问protected修饰的变量

	}

}
