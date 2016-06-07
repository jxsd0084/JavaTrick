package bj.powernode.advance.Charpter09.test5;

/**
 * 完成一个自动扩容的栈类 该对象的初始化容量是10个,满了之后,每次动态的增加10个容量
 *
 * @author Administrator
 */
public class AotoSatck {

	private String[] arr     = new String[ 10 ];
	private int      addSize = 10; // 动态的增加10个容量
	private int      index   = 0;

	/**
	 * 压栈的方法
	 *
	 * @param s ,要压栈的数据
	 */
	public void push( String s ) {
		if ( index < arr.length ) {
			arr[ index ] = s;
			index++;
		}
		// 当原来的数组对象已经存满的情况下,要考虑扩容了
		else {
			String[] temp = new String[ arr.length + addSize ];
			System.arraycopy( arr, 0, temp, 0, arr.length );
			arr = temp;
			arr[ index ] = s;
			index++;
		}
	}

	/**
	 * 弹栈的方法 ,弹栈的时候,控制数组的空余量不能大于10个
	 *
	 * @return 弹栈的数据
	 */
	public String pop() {
		if ( index > 0 ) {
			index--;
			String t = arr[ index ];
			arr[ index ] = null;
			return t;
		} else {
			System.out.println( "栈内已经没有数据了" );
			return null;
		}
	}

	/**
	 * 取得栈的大小
	 *
	 * @return
	 */
	public int size() {
		return arr.length;
	}

	/**
	 * 取得数栈中已经使用的大小
	 *
	 * @return
	 */
	public int usedSize() {
		return index;
	}

	public static void main( String[] args ) {
		AotoSatck aa = new AotoSatck();

		for ( int i = 1; i < 10059; i++ ) {
			String s = "Hello" + i;
			aa.push( s );
		}

		System.out.println( "数组类的大小:" + aa.size() );
		System.out.println( "数组类已经使用的大小:" + aa.usedSize() );
	}
}
