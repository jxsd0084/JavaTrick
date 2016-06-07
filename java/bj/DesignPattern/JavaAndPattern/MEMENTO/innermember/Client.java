package bj.DesignPattern.JavaAndPattern.MEMENTO.innermember;

public class Client {

	private static Outer outer;

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		outer = new Outer();

		Outer.Inner inner = outer.instantiateInner();

		inner.testThis();
	}

}

