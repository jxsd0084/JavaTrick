package bj.powernode.basic.day13.design_pattern.singleton;

public class Test2 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Singleton2 s1 = Singleton2.getSingleton();
		Singleton2 s2 = Singleton2.getSingleton();

		System.out.println( s1 == s2 );

	}

}
