package bj.mldn.javase02.ch05.no12;

class Demo {

	{                   // 直接在类中编写代码块，称为构造块
		System.out.println( "1、构造块。" );
	}

	public Demo() {     // 定义构造方法
		System.out.println( "2、构造方法。" );
	}
}

public class CodeDemo02 {

	public static void main( String args[] ) {

		new Demo();        // 实例化对象
		new Demo();        // 实例化对象
		new Demo();        // 实例化对象
	}

}
