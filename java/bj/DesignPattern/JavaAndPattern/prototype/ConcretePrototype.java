package bj.DesignPattern.JavaAndPattern.prototype;

public class ConcretePrototype implements Prototype {

	public Object clone() {
		try {
			return super.clone();
		} catch ( CloneNotSupportedException e ) {
			//write your code here
			return null;
		}
	}
}
