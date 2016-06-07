package bj.DesignPattern.JavaAndPattern.OBSERVER.CONCEPT;

public interface Subject {

	public void attach( Observer observer );

	public void detach( Observer observer );

	void notifyObservers();

}
