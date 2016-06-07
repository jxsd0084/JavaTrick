package bj.jakeChen.DataStructure;

/**
 * Created by chenlong on 2016/4/26.
 * <p>
 * 设有n个人依围成一圈，从第1个人开始报数，数到第m个人出列，然后从出列的下一个人开始报数，数到第m个人又出列，…，如此反复到所有的人全部出列为止。设n个人的编号分别为1，2，…，n，打印出出列的顺序.
 * <p>
 * 思路：用Java实现循环链表来解决。
 * <p>
 * URL: http://blog.csdn.net/it5555/article/details/3143692
 */

class node {                            //    节点类

	int  no;                            //    序列
	node next;                          //    下一个节点

	public node( int no ) {

		this( no, null );
	}

	public node( int no, node next ) {  //    构造方法

		this.no = no;
		this.next = next;
	}

	public int getItem() {
		return no;
	}

	public void setNext( node next ) {
		this.next = next;
	}

	public node getNext() {
		return next;
	}

}


public class linkedlist {

	private node head, tail;        //    头指针，尾指针
	int size;


	public linkedlist() {           //    构造方法，建一个空链表

		size = 0;
		head = tail = null;
	}

	public void addhead( int i ) {
		head = new node( i, head );

		if ( tail == null ) {
			tail = head;
		}
		size++;
	}

	public void addtail( int i ) {
		tail.next = new node( i );
		tail = tail.next;
		tail.next = head;
		size++;
	}


	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		int n = Integer.parseInt( args[ 0 ] );      //  n为节点个数，由string数组args输入
		int m = Integer.parseInt( args[ 1 ] );      //  m为报几个数

		linkedlist LL = new linkedlist();

		LL.addhead( 1 );

		/*构造循环链表*/
		for ( int i = 2; i < n + 1; i++ ) {
			LL.addtail( i );
		}

		node temp = LL.head;
		while ( LL.size != 0 ) {
			for ( int i = 0; i < m - 2; i++ ) {
				temp = temp.next;
			}
			System.out.print( temp.getNext().getItem() + "->" );

			temp.setNext( temp.getNext().getNext() );
			temp = temp.next;
			LL.size--;
		}
	}

}