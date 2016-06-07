package bj.mldn.javase02.ch05.no13;

class Singleton6 {

	private static Singleton6 instance = new Singleton6();    // 在内部产生本类的实例化对象

	public static Singleton6 getInstance() {                  // 通过静态方法取得instance对象
		return instance;
	}

	private Singleton6() {        // 将构造方法进行了封装，私有化
	}

	public void print() {

		System.out.println( "Hello World!!!" );
	}
};

public class SingletonDemo06 {

	public static void main( String args[] ) {

		Singleton6 s1 = null;    // 声明对象
		Singleton6 s2 = null;    // 声明对象
		Singleton6 s3 = null;    // 声明对象
		s1 = Singleton6.getInstance();    // 取得实例化对象
		s2 = Singleton6.getInstance();    // 取得实例化对象
		s3 = Singleton6.getInstance();    // 取得实例化对象

		s1.print();        // 调用方法
		s2.print();        // 调用方法
		s3.print();        // 调用方法
	}

}
