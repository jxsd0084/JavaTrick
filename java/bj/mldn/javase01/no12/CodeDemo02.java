package bj.mldn.javase01.no12;

class Demo2 {

	{    // 构造块
		System.out.println( "*********** 构造块 *************" );
	}

	public Demo2() {    // 构造方法
		System.out.println( "*********** 构造方法 *************" );
	}
}

public class CodeDemo02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		new Demo2();
		new Demo2();
		new Demo2();

	}

}
