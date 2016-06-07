package bj.DesignPattern.JavaAndPattern.VISITOR.VISITOR0;

public class NodeB extends Node {

	public void accept( Visitor visitor ) {
		visitor.visit( this );
	}

	public String operationB() {
		return "NodeB is visited";
	}

}
