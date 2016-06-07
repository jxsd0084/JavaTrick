package bj.DesignPattern.sxt_pattern.command;

public class Client {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		Command c = new ConcreteCommand( new Receiver() );
		Invoke  i = new Invoke( c );
		i.call();

//		new Receiver().action();
	}

}
