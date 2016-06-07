package bj.crazy.ch06.u007;

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
class StaticOut {

	// 定义一个静态内部类，不使用访问控制符，即同一个包中其他类可访问该内部类
	static class StaticIn {

		public StaticIn() {

			System.out.println( "静态内部类的构造器" );
		}
	}
}

public class CreateStaticInnerInstance {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		StaticOut.StaticIn in = new StaticOut.StaticIn();

		/*

			上面代码可改为如下两行代码：

			使用OutterClass.InnerClass的形式定义内部类变量
			StaticOut.StaticIn in;

			通过new来调用内部类构造器创建静态内部类实例
			in = new StaticOut.StaticIn();

		*/
	}
}
