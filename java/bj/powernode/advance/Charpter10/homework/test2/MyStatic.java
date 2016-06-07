package bj.powernode.advance.Charpter10.homework.test2;

/*

 完成自动扩容/减容的栈类
 在压栈的时候,原来的容量自动增加10个长度
 在弹栈的时候,控制空余量不能大于10个长度

*/
public class MyStatic {

	private String[] arr     = new String[ 10 ];
	private int      addSize = 10;
	private int      index   = 0;

	public void push( String s ) {

		if ( index < arr.length ) {
			arr[ index ] = s;

			index++;

		} else {
			String[] temp = new String[ arr.length + addSize ];
			System.arraycopy( arr, 0, temp, 0, arr.length );

			arr = temp;
			arr[ index ] = s;
			index++;
		}
	}

	public String pop() throws StackException {

		if ( index > 0 ) {
			// 首先要弹出数据
			index--;
			String s = arr[ index ];
			arr[ index ] = null;

			// 空余量大于10个的时候,要减少容量了
			if ( arr.length - index > 10 ) {
				String[] temp = new String[ arr.length - addSize ];
				System.arraycopy( arr, 0, temp, 0, index );
				arr = temp;
			}

			return s;

		} else {

			throw new StackException( "栈内已经没有数据了" );
		}
	}

	public int size() {

		return arr.length;
	}

	public int usedSize() {

		return index;
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		MyStatic aa = new MyStatic();

		for ( int i = 0; i < 11; i++ ) {

			String s = "Hello" + i;
			aa.push( s );
		}

		System.out.println( "数组类的大小:" + aa.size() );
		System.out.println( "数组类已经使用的大小:" + aa.usedSize() );

		try {

			for ( int i = 1; i < aa.size(); i++ ) {

				String s = aa.pop();
				System.out.println( "弹栈的数据:" + s );
			}
		} catch ( StackException ex ) {

			ex.printStackTrace();
		}

		System.out.println( "数组类的大小:" + aa.size() );
		System.out.println( "数组类已经使用的大小:" + aa.usedSize() );

	}

}
