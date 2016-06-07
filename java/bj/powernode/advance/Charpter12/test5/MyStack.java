package bj.powernode.advance.Charpter12.test5;

import java.util.*;

// 创建类MyStack实现Iterable接口(这个接口下面只有一个方法:iterator(),返回的是一个 Iterator<T>泛型)
public class MyStack implements Iterable< String > {

	// 初始化LinkedList<String>(底层:链表)
	private LinkedList< String > list = new LinkedList< String >();

	// 压栈方法,参数(String s)
	public void push( String s ) {

		// getLast()返回此列表的最后一个元素
		list.addLast( s );
	}

	// 弹栈方法,返回String类型的数据,抛出StackException自定义异常
	public String pop() throws StackException {

		// 如果有元素, size()返回此列表的元素数
		if ( list.size() > 0 ) {
			// 返回removeLast()移除并返回此列表的最后一个元素

			return list.removeLast();

		} else {

			// 否则,抛出StackException自定义异常
			throw new StackException( "栈内已经没有数据了" );
		}
	}

	// 重写Iterable接口中的Iterator方法,注意:此处的泛型是String类型的
	public Iterator< String > iterator() {

		// 返回迭代器迭代出的元素
		return list.iterator();
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建MyStack对象
		MyStack ms = new MyStack();

		// for循环从0到10
		for ( int i = 0; i <= 10; i++ ) {

			// 将循环得到的i值赋给String类型的s
			String s = "Hello-" + i;

			// 调用弹栈方法
			ms.push( s );
		}


		// 增强for循环遍历
		for ( String s : ms ) {

			System.out.println( s );
		}






		System.out.println( "==================" );






		// 创建Iterator对象
		Iterator< String > it = ms.iterator();
		// while循环遍历
		while ( it.hasNext() ) {

			System.out.println( it.next() );
		}




		try {

			// for循环从0到20
			for ( int i = 0; i <= 20; i++ ) {

				// 将弹栈得到的元素赋给String类型的s
				String s = ms.pop();

				System.out.println( "弹栈的数据:" + s );
			}

		} catch ( StackException ex ) {

			ex.printStackTrace();
		}

	}

}
