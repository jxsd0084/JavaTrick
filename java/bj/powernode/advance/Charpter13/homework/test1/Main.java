package bj.powernode.advance.Charpter13.homework.test1;

/**
 * 【程序1】
 * 队列是一种常用的数据结构，它采用“先进先出”的方
 * 式来存储数据，要求写一个类来模拟队列这种数据类
 * 型，要求底层采用List来存储数据，并且让这一类型
 * 实现Iterable接口，使之成为可循环遍历的类。
 */
public class Main {

	/**
	 * 测试
	 *
	 * @param args
	 * @throws QueueException
	 */
	public static void main( String[] args ) throws QueueException {

		Queue qu = new Queue();

		for ( int i = 0; i < 11; i++ ) {

			qu.push( "GoodBye" + i );
		}



		for ( String s : qu ) {
			System.out.println( s );
		}



		System.out.println( "------------------------------" );


		try {

			for ( int j = 0; j < 15; j++ ) {

				String s = qu.pop();
				System.out.println( s );
			}

		} catch ( QueueException ex ) {

			ex.printStackTrace();
		}

	}

}
