package bj.powernode.advance.Charpter08.test3;

/**
 * 实现一个后进先出的栈类
 *
 * @author Administrator
 */
public class MyStack {

	private String[] arrs;
	private int index = 0; // 控制数组下标的变量

	/**
	 * 返回栈的大小
	 *
	 * @return 栈的大小
	 */
	public int size() {

		return arrs.length;
	}

	/**
	 * 返回栈内已使用的大小
	 *
	 * @return
	 */
	public int usedSize() {

		return index;
	}

	public MyStack( int length ) {

		arrs = new String[ length ];
	}

	/**
	 * 进栈的方法
	 *
	 * @param s ,要进栈的数据
	 * @throws StackException
	 */
	public void push( String s ) /* throws StackException */ {

		if ( index < arrs.length ) {
			arrs[ index ] = s;
			index++;
		} else {
			// System.out.println("数组下标已经越界");

			StackException ex = new StackException( "栈已满,不能在添加数据了" );
			throw ex;
		}
	}

	/**
	 * 弹栈的方法
	 *
	 * @return 出栈的数据
	 * @throws StackException
	 */
	public String pop() /* throws StackException */ {

		if ( index > 0 ) {
			index--;
			String s = arrs[ index ];
			arrs[ index ] = null;

			return s;
		} else {
			StackException ex = new StackException( "栈已空,不能在弹出数据了" );
			throw ex;
		}
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		MyStack ms = new MyStack( 10 );

		// try {
		ms.push( "Hello1" );
		ms.push( "Hello2" );
		ms.push( "Hello3" );
		ms.push( "Hello4" );
		ms.push( "Hello5" );
		ms.push( "Hello6" );
		ms.push( "Hello7" );
		ms.push( "Hello8" );

		// } catch (StackException ex) {
		// ex.printStackTrace();
		// }

		// try {
		for ( int i = 10; i < 20; i++ ) {
			System.out.println( ms.pop() );
		}
		// } catch (StackException e) {
		// // TODO Auto-generated catch block
		// // e.printStackTrace();
		// System.out.println(e.getMessage());
		// }

	}
}
