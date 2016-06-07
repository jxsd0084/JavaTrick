package bj.mldn.javase02.ch15.no01;

class X {

}

public class GetClassDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String args[] ) {

		X x = new X();    // 实例化X类的对象
		System.out.println( x.getClass().getName() );    // 得到对象所在的类
	}
}
