package bj.DesignPattern.JavaAndPattern.VISITOR.visitorsimplified;

public class NodeA extends Node {

	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}

	public String operationA() {

		return "NodeA is visited";
	}

}
