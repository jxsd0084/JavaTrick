package bj.mldn.javase02.ch05.no13;

class Singleton5 {

	private static Singleton5 instance = new Singleton5();    // 在内部产生本类的实例化对象

	public static Singleton5 getInstance() {                  // 通过静态方法取得instance对象
		return instance;
	}

	private Singleton5() {        // 将构造方法进行了封装，私有化
	}

	public void print() {

		System.out.println( "Hello World!!!" );
	}
}

public class SingletonDemo05 {

	public static void main( String args[] ) {

		Singleton5 s1 = null;             // 声明对象
		s1 = Singleton5.getInstance();    // 取得实例化对象
		s1.print();                       // 调用方法
	}

}
