package bj.powernode.advance.Charpter05.test3;

public class TestSingleton {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println( s1 == s2 );
		System.out.println( s1.hashCode() + "     " + s2.hashCode() );

	}

}
