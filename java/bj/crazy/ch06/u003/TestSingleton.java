package bj.crazy.ch06.u003;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class Singleton {

	// 使用一个变量来缓存曾经创建的实例
	private static Singleton instance;

	// 将构造器使用private修饰，隐藏该构造器
	private Singleton() {

	}

	// 提供一个静态方法，用于返回Singleton实例
	// 该方法可以加入自定义的控制，保证只产生一个Singleton对象
	public static Singleton getInstance() {

		// 如果instance为null，表明还不曾创建Singleton对象
		// 如果instance不为null，则表明已经创建了Singleton对象，将不会执行该方法
		if ( instance == null ) {

			// 创建一个Singleton对象，并将其缓存起来
			instance = new Singleton();
		}

		return instance;
	}
}

public class TestSingleton {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建Singleton对象不能通过构造器，只能通过getInstance方法
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		// 将输出true
		System.out.println( s1 == s2 );

	}

}
