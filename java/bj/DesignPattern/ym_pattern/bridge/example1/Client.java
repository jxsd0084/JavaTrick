package bj.DesignPattern.ym_pattern.bridge.example1;

public class Client {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Message m = new CommonMessageSMS();
		m.send( "aa", "au" );

		m = new CommonMessageEmail();
		m.send( "aa", "au" );

	}

}
