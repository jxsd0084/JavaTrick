package bj.DesignPattern.JavaAndPattern.ITERATOR.WHITEBOX;

public class Client {

	/**
	 * @directed
	 */
	private Iterator it;

	/**
	 * @directed
	 */
	private Aggregate agg = new ConcreteAggregate();

	public void operation() {
		it = agg.createIterator();

		while ( !it.isDone() ) {
			System.out.println( it.currentItem().toString() );
			it.next();
		}
	}

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {
		Client client = new Client();

		client.operation();
	}

}
