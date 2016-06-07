package bj.DesignPattern.JavaAndPattern.OBSERVER.variation;

public class ConcreteSubject extends Subject {

	private String state;

	public void change( String newState ) {
		state = newState;

		this.notifyObservers();
	}

}
