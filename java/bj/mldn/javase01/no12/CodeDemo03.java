package bj.mldn.javase01.no12;

class Demo3 {

	{    // 构造块
		System.out.println( "*********** 构造块 *************" );
	}

	static {
		System.out.println( "*********** 类中的静态块 *************" );
	}

	public Demo3() {    // 构造方法
		System.out.println( "*********** 构造方法 *************" );
	}
}

public class CodeDemo03 {

	static {
		System.out.println( "*********** 主类中的静态块 *************" );
	}

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		new Demo3();
		new Demo3();
		new Demo3();

	}

}
