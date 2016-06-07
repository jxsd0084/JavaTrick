package bj.DesignPattern.JavaAndPattern.VISITOR.visitorsimplified;

public class Visitor {

	public void visit( NodeA nodeA ) {

		System.out.println( nodeA.operationA() );
	}

	public void visit( NodeB nodeB ) {

		System.out.println( nodeB.operationB() );
	}

}
