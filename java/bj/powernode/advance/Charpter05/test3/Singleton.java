package bj.powernode.advance.Charpter05.test3;

// 软件设计模式
public class Singleton {

	// 饿汉式单例模式
	// 第三步提供一个私有的的静态实例
	private static Singleton instance = new Singleton();

	// 第一步构造方法私有化
	private Singleton() {

	}

	// 第二步提供一个公开的静态获取实例的方法
	public static Singleton getInstance() {

		return instance;
	}

	// 懒汉式单例模式
	// 第三步提供一个私有的的静态实例
	private static Singleton instance2;

	// 第一步构造方法私有化
//	private Singleton() {
//
//	}

	// 第二步提供一个公开的静态获取实例的方法
	public synchronized static Singleton getInstance2() {

		if ( instance2 == null ) {
			instance2 = new Singleton();
		}

		return instance2;
	}

}
