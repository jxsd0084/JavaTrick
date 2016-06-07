package bj.mldn.javase02.ch15.no06;

interface Fruit {

	public void eat();    // 吃水果
}

class Apple implements Fruit {

	public void eat() {            // 覆写eat()方法
		System.out.println( "** 吃苹果" );
	}
}

class Orange implements Fruit {

	public void eat() {

		System.out.println( "** 吃橘子" );
	}
}

class Factory {

	public static Fruit getInstance( String className ) {

		Fruit fruit = null;
		try {
			fruit = (Fruit) Class.forName( className ).newInstance();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return fruit;
	}
}

public class FactoryDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Fruit f = Factory.getInstance( "org.lxh.demo15.factorydemo01.Apple" );
		if ( f != null ) {
			f.eat();
		}
	}
}
