package bj.mldn.javase02.ch05.no13;

class Singleton1 {

	private Singleton1() {        // 将构造方法进行了封装，私有化
	}

	public void print() {

		System.out.println( "Hello World!!!" );
	}

}
