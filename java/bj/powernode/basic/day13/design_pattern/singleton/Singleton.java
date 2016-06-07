package bj.powernode.basic.day13.design_pattern.singleton;



/*

	java中的设计模式包括: 23种.
	
	1.单例模式
	2.工厂模式
	3.MVC模式
	4.适配器模式.
	....
	
	单例模式: 在整个应用程序运行过程中,如何保证某个类型的实例只有一个.

*/

// 保证在JVM中永远只有一个Singleton类型的对象.

// 懒汉式单例模式:用到时再创建对象.

public class Singleton {

	// 声明一个静态成员变量.
	private static Singleton s;


	// 缺省构造器
	private Singleton() {

		super();
	}


	// 获取Singleton类型的对象
	public static Singleton getSingleton() {

		if ( s == null ) {

			s = new Singleton();
		}

		return s;
	}

}
