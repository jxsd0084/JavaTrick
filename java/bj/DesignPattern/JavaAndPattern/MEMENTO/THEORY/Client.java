package bj.DesignPattern.JavaAndPattern.MEMENTO.THEORY;

public class Client {

	private static Originator o = new Originator();
	private static Caretaker  c = new Caretaker();

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		o.setState( "On" );

		// Store internal state
		c.saveMemento( o.createMemento() );

		// Continue changing originator
		o.setState( "Off" );

		// Restore saved state
		o.restoreMemento( c.retrieveMemento() );

	}

}
