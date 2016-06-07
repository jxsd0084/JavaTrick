package bj.DesignPattern.JavaAndPattern.PROXY;

public class Client {

	private static Subject subject;

	/**
	 * 测试
 	 * @param args
	 */
	static public void main( String[] args ) {
		subject = new ProxySubject();
		subject.request();
		subject.request();
	}

}
