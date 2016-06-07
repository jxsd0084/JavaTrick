package bj.mldn.javase02.ch05.no13;

class Singleton3 {

	Singleton3 instance = new Singleton3();    // 在内部产生本类的实例化对象

	private Singleton3() {                     // 将构造方法进行了封装，私有化
	}

	public void print() {

		System.out.println( "Hello World!!!" );
	}
};

public class SingletonDemo03 {

	public static void main( String args[] ) {

		Singleton3 s1 = null;    // 声明对象
	}

}
