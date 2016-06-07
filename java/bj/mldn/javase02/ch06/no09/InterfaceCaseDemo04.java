package bj.mldn.javase02.ch06.no09;

interface Fruit2 {    // 定义一个水果接口

	public void eat();    // 吃水果
}

class Apple2 implements Fruit2 {

	public void eat() {

		System.out.println( "** 吃苹果。" );
	}
}

class Orange2 implements Fruit2 {

	public void eat() {

		System.out.println( "** 吃橘子。" );
	}
}

class Factory2 {    // 定义工厂类

	public static Fruit2 getInstance( String className ) {

		Fruit2 f = null;
		if ( "apple".equals( className ) ) {    // 判断是否要的是苹果的子类
			f = new Apple2();
		}
		if ( "orange".equals( className ) ) {    // 判断是否要的是橘子的子类
			f = new Orange2();
		}
		return f;
	}
}

public class InterfaceCaseDemo04 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Fruit2 f = Factory2.getInstance( null );    // 实例化接口
		f.eat();
	}
}
