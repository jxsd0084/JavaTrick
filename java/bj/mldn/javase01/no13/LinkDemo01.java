package bj.mldn.javase01.no13;

class Node {

	private String name;    // 保存节点的名字
	private Node   next;    // 保存下一个节点

	public Node( String name ) {

		this.name = name;
	}

	public void setNext( Node next ) {

		this.next = next;
	}

	public Node getNext() {

		return this.next;
	}

	public String getName() {

		return this.name;
	}
}

public class LinkDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Node root = new Node( "根节点" );
		Node n1   = new Node( "第一节车厢" );
		Node n2   = new Node( "第二节车厢" );
		Node n3   = new Node( "第三节车厢" );

		root.setNext( n1 );

		n1.setNext( n2 );
		n2.setNext( n3 );

		print( root );

	}

	public static void print( Node node ) {

		if ( node != null ) {

			System.out.print( node.getName() + " --> " );
		}

		if ( node.getNext() != null ) {

			print( node.getNext() );
		}
	}

}