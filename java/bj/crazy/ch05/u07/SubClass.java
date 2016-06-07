package bj.crazy.ch05.u07;

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
class BaseClass {

	public int book = 6;

	public void base() {

		System.out.println( "父类的普通方法" );
	}

	public void test() {

		System.out.println( "父类的被覆盖的方法" );
	}
}

public class SubClass extends BaseClass {

	// 重新定义一个book实例属性覆盖父类的book实例属性
	public String book = "轻量级J2EE企业应用实战";

	public void test() {

		System.out.println( "子类的覆盖父类的方法" );
	}

	public void sub() {

		System.out.println( "子类的普通方法" );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 下面编译时类型和运行时类型完全一样，因此 不存在多态
		BaseClass bc = new BaseClass();

		// 输出 6
		System.out.println( bc.book );

		// 下面两次调用将执行BaseClass的方法
		bc.base();

		bc.test();








		// 下面编译时类型和运行时类型完全一样，因此 不存在多态
		SubClass sc = new SubClass();

		// 输出"轻量级J2EE企业应用实战"
		System.out.println( sc.book );

		// 下面调用将执行从父类继承到的base方法
		sc.base();

		// 下面调用将执行从当前类的test方法
		sc.test();

		// 下面调用将执行从当前类的sub方法
		sc.sub();







		// 下面编译时类型和运行时类型不一样，多态发生
		BaseClass ploymophicBc = new SubClass();

		// 输出 6 —— 表明访问的是父类属性
		System.out.println( ploymophicBc.book );

		// 下面调用将执行从父类继承到的base方法
		ploymophicBc.base();

		// 下面调用将执行从当前类的test方法
		ploymophicBc.test();

		// 因为ploymophicBc的编译类型是BaseClass，BaseClass类没有提供sub方法
		// 所以下面代码编译时会出现错误。

		// ploymophicBc.sub();







	}

}
