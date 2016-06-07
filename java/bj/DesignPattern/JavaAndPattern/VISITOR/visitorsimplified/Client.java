package bj.DesignPattern.JavaAndPattern.VISITOR.visitorsimplified;

public class Client {

	private static ObjectStructure aObjects;
	private static Visitor         visitor;

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {
		aObjects = new ObjectStructure();

		aObjects.add( new NodeA() );
		aObjects.add( new NodeB() );

		visitor = new Visitor();
		aObjects.action( visitor );

	}

}
