package bj.mldn.javase02.ch06.no09;

interface Fruit3 {    // 定义一个水果接口

	public void eat();    // 吃水果
}

class Apple3 implements Fruit3 {

	public void eat() {

		System.out.println( "** 吃苹果。" );
	}
}

class Orange3 implements Fruit3 {

	public void eat() {

		System.out.println( "** 吃橘子。" );
	}
}

class Factory3 {    // 定义工厂类

	public static Fruit3 getInstance( String className ) {

		Fruit3 f = null;
		if ( "apple".equals( className ) ) {    // 判断是否要的是苹果的子类
			f = new Apple3();
		}
		if ( "orange".equals( className ) ) {    // 判断是否要的是橘子的子类
			f = new Orange3();
		}
		return f;
	}
}

public class InterfaceCaseDemo05 {

	public static void main( String args[] ) {

		Fruit3 f = Factory3.getInstance( args[ 0 ] );    // 实例化接口
		if ( f != null ) {    // 判断是否取得实例
			f.eat();
		}
	}
}
