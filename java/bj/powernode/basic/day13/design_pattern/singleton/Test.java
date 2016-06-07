package bj.powernode.basic.day13.design_pattern.singleton;

public class Test {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建Singleton类型的对象

		/*

			Singleton s1 = new Singleton();
			Singleton s2 = new Singleton();

			System.out.println(s1);
			System.out.println(s2);

			System.out.println(s1==s2);  // == 判断的是内存地址.

		*/

		// 在JVM中生成新对象的罪魁祸首. new

		// 单例模式要求:构造方法私有化.对外提供一个公开的访问方法,该方法的主要功能是提供一个Singleton类型的对象.

		Singleton s1 = Singleton.getSingleton();
		Singleton s2 = Singleton.getSingleton();

		System.out.println( s1 );
		System.out.println( s2 );
		System.out.println( s1 == s2 );

	}

}
