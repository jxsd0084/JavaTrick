package bj.mldn.javase02.ch06.no09;

interface Fruit1 {    // 定义一个水果接口

	public void eat();    // 吃水果
}

class Apple1 implements Fruit1 {

	public void eat() {

		System.out.println( "** 吃苹果。" );
	}
}

class Orange1 implements Fruit1 {

	public void eat() {

		System.out.println( "** 吃橘子。" );
	}
}

public class InterfaceCaseDemo03 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Fruit1 f = new Apple1();    // 实例化接口
		f.eat();
	}
}
