package bj.crazy.ch05.u06;

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
public class Ostrich extends Bird {

	// 重写Bird类的fly方法
	public void fly() {

		System.out.println( "我只能在地上奔跑..." );
	}

	public void callOverridedMethod() {
		// 在子类方法中通过super来显式调用父类被覆盖的方法。
		super.fly();
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 创建Ostrich对象
		Ostrich os = new Ostrich();

		// 执行Ostrich对象的fly方法，将输出"我只能在地上奔跑..."
		os.fly();

		os.callOverridedMethod();

	}

}
