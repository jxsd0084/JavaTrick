package bj.geym.ch10.staticdead;

public class ChildStatic extends SimpleStatic {

	static {
		number = 2;
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( number );
	}
}
