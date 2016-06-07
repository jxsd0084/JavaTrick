package bj.powernode.advance.Charpter05.test5;

// 一个类继承一个抽象类,就是要实现抽象类中所有的抽象方法,则这个类是具体类

// 如果只实现了抽象类部分的抽象方法,则这个类一定要声明为抽象类
public class QQ extends Car {

	@Override
	public void run() {

		System.out.println( "QQ在以100迈的速度行驶" );
	}

	@Override
	public void stop() {

		System.out.println( "QQ在刹车" );
	}

	public QQ() {

		super();
		System.out.println( "QQ类的构造方法被调用" );
	}

}
