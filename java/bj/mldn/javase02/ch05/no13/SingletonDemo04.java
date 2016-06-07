package bj.mldn.javase02.ch05.no13;

class Singleton4 {

	static Singleton4 instance = new Singleton4();    // 在内部产生本类的实例化对象

	private Singleton4() {        // 将构造方法进行了封装，私有化
	}

	public void print() {

		System.out.println( "Hello World!!!" );
	}
}

public class SingletonDemo04 {

	public static void main( String args[] ) {

		Singleton4 s1 = null;       // 声明对象
		s1 = Singleton4.instance;   // 取得实例化对象
		s1.print();                 // 调用方法
	}
}
