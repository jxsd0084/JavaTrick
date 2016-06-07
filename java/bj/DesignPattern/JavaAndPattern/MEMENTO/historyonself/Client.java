package bj.DesignPattern.JavaAndPattern.MEMENTO.historyonself;

public class Client {

	private static Originator o;
	private static MementoIF  memento;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		o = new Originator();

		o.changeState( "State 1" );
		memento = o.createMemento();

		o.changeState( "State 2" );
		o.restoreMemento( memento );
	}

}

