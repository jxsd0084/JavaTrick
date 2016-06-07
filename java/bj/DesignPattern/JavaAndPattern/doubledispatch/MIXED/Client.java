package bj.DesignPattern.JavaAndPattern.doubledispatch.MIXED;

public class Client {

	private static Super a;
	private static Super b;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		a = new SubA();
		b = new SubB();

		a.operation( b );
	}

}

