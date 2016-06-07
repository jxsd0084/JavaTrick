package bj.mldn.javase02.ch05.no12;

class Demo2 {

	{                   // 直接在类中编写代码块，称为构造块
		System.out.println( "1、构造块。" );
	}

	static {            // 使用static，称为静态代码块
		System.out.println( "0、静态代码块" );
	}

	public Demo2() {    // 定义构造方法
		System.out.println( "2、构造方法。" );
	}
};

public class CodeDemo03 {

	static {            // 在主方法所在的类中定义静态块
		System.out.println( "在主方法所在类中定义的代码块" );
	}

	public static void main( String args[] ) {

		new Demo2();        // 实例化对象
		new Demo2();        // 实例化对象
		new Demo2();        // 实例化对象
	}
};
