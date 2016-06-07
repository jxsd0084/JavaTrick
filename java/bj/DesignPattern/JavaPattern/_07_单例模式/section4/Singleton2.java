package bj.DesignPattern.JavaPattern._07_单例模式.section4;

public class Singleton2 {

	private static Singleton2 instance = new Singleton2();

	public Singleton2() {

	}

	public static Singleton2 getInstance() {
		if ( instance == null ) {
			synchronized ( Singleton2.class ) {
				instance = new Singleton2();
			}
		}
		return instance;
	}


	public static void main( String[] args ) {

	}

}
