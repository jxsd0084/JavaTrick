package bj.powernode.advance.Charpter14.homework;

//  创建类实现Runnable接口
public class practice04 implements Runnable {

	private int i;

	@Override
	public void run() {

		for (; i < 100; i++ ) {
			// 当线程类实现Runnable接口时,如果想获取读取线程,只能用Thread.currentThread()方法
			System.out.println( Thread.currentThread().getName() + "" + i );

		}

	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		for ( int i = 0; i < 100; i++ ) {
			System.out.println( Thread.currentThread().getName() + "" + i );
			if ( i == 20 ) {
				practice04 p4 = new practice04();
				// 通过new Thread(target,name)方法创建新线程
				new Thread( p4, "新线程1" ).start();
				new Thread( p4, "新线程2" ).start();
			}
		}
	}

}
