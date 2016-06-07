package bj.DesignPattern.JavaAndPattern.OBSERVER.variation;

public class Client {

	private static ConcreteSubject subject;
	private static Observer        observer;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		subject = new ConcreteSubject();

		observer = new ConcreteObserver();

		subject.attach( observer );

		subject.change( "new state" );

	}

}

