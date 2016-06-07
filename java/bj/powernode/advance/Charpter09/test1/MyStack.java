package bj.powernode.advance.Charpter09.test1;

/**
 * 实现一个后进先出的栈类
 *
 * @author Administrator
 */
public class MyStack {

	// String类型的数组属性没有,此处只有内存空间,还没有赋值
	private String[] arrs;
	// 控制数组下标的变量
	private int index = 0;

	/**
	 * 返回栈的大小
	 *
	 * @return 栈的大小就是数组的长度
	 */
	public int size() {
		return arrs.length;
	}

	/**
	 * 返回栈内已使用的大小就是下标的位置
	 *
	 * @return
	 */
	public int usedSize() {
		return index;
	}

	// 有参构造,参数int length,而且在构造方法中还new了一个String类型数组,并且在构造方法中给数组赋值
	public MyStack( int length ) {
		arrs = new String[ length ];
	}

	/**
	 * 进栈的方法
	 *
	 * @param s 要进栈的数据
	 */
	public void push( String s ) {
		// 如果小标小于数组的长度
		if ( index < arrs.length ) {
			// 将String赋给数组,由下标指定
			arrs[ index ] = s;
			// 赋值完之后,下标向上移动一位
			index++;
		} else {
			// 否则,报错
			System.out.println( "数组下标已经越界" );
		}

	}

	/**
	 * 弹栈的方法
	 *
	 * @return 出栈的数据
	 */
	public String pop() {
		// 如果下标大于0
		if ( index > 0 ) {
			// 下标自减一次(向下移动)
			index--;
			// 将数组中的值赋给String类型的s
			String s = arrs[ index ];
			// 将数组下标所指位置的元素清空
			arrs[ index ] = null;
			// 将得到的Sring类型的s返回
			return s;
		} else {
			// 否则,输出异常信息并返回null
			System.out.println( "栈里面已经没有数据了" );
			return null;
		}
	}

	// 主方法测试
	public static void main( String[] args ) {

		// 创建MyStack类的对象
		MyStack ms = new MyStack( 10 );

		// 向栈里面添加元素,调用push方法
		ms.push( "Hello1" );
		ms.push( "Hello2" );
		ms.push( "Hello3" );
		ms.push( "Hello4" );
		ms.push( "Hello5" );
		ms.push( "Hello6" );
		ms.push( "Hello7" );
		ms.push( "Hello8" );

		// 输出调用size()和usedSize()方法返回容量和剩余容量
		System.out.println( ms.size() + "       " + ms.usedSize() );
		System.out.println( ms.pop() );
		System.out.println( ms.pop() );
		System.out.println( ms.pop() );

		// 输出调用size()和usedSize()方法返回容量和剩余容量
		System.out.println( ms.size() + "       " + ms.usedSize() );
	}
}
