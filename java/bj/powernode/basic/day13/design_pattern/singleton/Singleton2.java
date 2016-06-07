package bj.powernode.basic.day13.design_pattern.singleton;


/*

	饿汉式单例模式.

*/
public class Singleton2 {

	// 类加载时期执行.
	private static Singleton2 s = new Singleton2();

	// 构造方法私有化
	private Singleton2() {

		super();
	}

	// 提供一个公开获取对象的方法
	public static Singleton2 getSingleton() {

		return s;
	}

}
