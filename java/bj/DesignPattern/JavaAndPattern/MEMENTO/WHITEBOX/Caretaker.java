package bj.DesignPattern.JavaAndPattern.MEMENTO.WHITEBOX;

public class Caretaker {

	/**
	 * @link aggregation
	 * @label wide
	 */
	private Memento memento;

	public Memento retrieveMemento() {
		return this.memento;
	}

	public void saveMemento( Memento memento ) {
		this.memento = memento;
	}

}
