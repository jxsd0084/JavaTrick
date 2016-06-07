package bj.crazy.ch05.u08;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */

class Animal {

	private void beat() {

		System.out.println( "心脏跳动..." );
	}

	public void breath() {

		beat();

		System.out.println( "吸一口气，吐一口气，呼吸中..." );
	}
}

class Bird {

	// 将原来的父类嵌入原来的子类，作为子类的一个组合成分
	private Animal a;

	public Bird( Animal a ) {

		this.a = a;
	}

	// 重新定义一个自己的breath方法
	public void breath() {

		// 直接复用Animal提供的breath方法来实现Bird的breath方法。
		a.breath();
	}

	public void fly() {

		System.out.println( "我在天空自在的飞翔..." );
	}
}

class Wolf {

	// 将原来的父类嵌入原来的子类，作为子类的一个组合成分
	private Animal a;

	public Wolf( Animal a ) {

		this.a = a;
	}

	// 重新定义一个自己的breath方法
	public void breath() {

		// 直接复用Animal提供的breath方法来实现Bird的breath方法。
		a.breath();
	}

	public void run() {

		System.out.println( "我在陆地上的快速奔跑..." );
	}
}

public class TestComposite {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 此时需要显式创建被嵌入的对象

		Animal a1 = new Animal();
		Bird   b  = new Bird( a1 ); // 依赖关系




		b.breath();

		b.fly();








		// 此时需要显式创建被嵌入的对象

		Animal a2 = new Animal();
		Wolf   w  = new Wolf( a2 ); // 依赖关系





		w.breath();

		w.run();








	}

}
