package bj.mldn.javase01.no55.comparesdemo;

class BinaryTree { // 定义二叉树的操作类

	class Node {

		private Comparable data;    // 保存操作的数据内容
		private Node       left;    // 左子树
		private Node       right;   // 右子树

		public Node( Comparable< ? > data ) {

			this.data = data;
		}

		public void addNode( Node newNode ) {

			if ( newNode.data.compareTo( this.data ) <= 0 ) { // 放在左子树
				if ( this.left == null ) {    // 还没有左子树，可以直接保存在此节点下的左子树
					this.left = newNode;    // 保存左子树

				} else {
					this.left.addNode( newNode ); // 向下继续判断
				}
			}

			if ( newNode.data.compareTo( this.data ) > 0 ) { // 放在右子树
				if ( this.right == null ) {   // 还没有右子树，可以直接保存在此节点下的右子树
					this.right = newNode;   // 保存右子树

				} else {
					this.right.addNode( newNode );    // 向下继续判断
				}
			}
		}

		public void printNode() {          // 采用中序遍历
			if ( this.left != null ) {       // 存在左子树

				this.left.printNode();     // 继续找到下面的左子树
			}

			System.out.println( this.data ); // 找到根内容

			if ( this.right != null ) {      // 存在右子树

				this.right.printNode();    // 继续找到下面的右子树
			}
		}
	}

	private Node root; // 根节点

	public void add( Comparable data ) {     // 接收数据
		Node newNode = new Node( data );     // 实例化节点类
		if ( this.root == null ) {           // 没有根节点
			this.root = newNode;           // 第一个节点作为根节点

		} else {
			this.root.addNode( newNode );
		}
	}

	public void print() { // 输出

		this.root.printNode();// 输出全部的节点
	}
}

public class CompareableDemo03 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		BinaryTree bt = new BinaryTree();

		bt.add( 3 );
		bt.add( 5 );
		bt.add( 1 );
		bt.add( 0 );
		bt.add( 1 );
		bt.add( 9 );

		bt.print();

	}

}
