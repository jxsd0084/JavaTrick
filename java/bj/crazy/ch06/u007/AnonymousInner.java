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
abstract class Device {

	private String name;

	public abstract double getPrice();

	public Device() {

	}

	public Device( String name ) {

		this.name = name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return this.name;
	}
}

public class AnonymousInner {

	public void test( Device d ) {

		System.out.println( "购买了一个" + d.getName() + "，花掉了" + d.getPrice() );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		AnonymousInner ai = new AnonymousInner();

		// 调用有参数的构造器创建Device匿名实现类的对象
		ai.test( new Device( "电子示波器" ) {

			public double getPrice() {

				return 67.8;
			}
		} );

		// 调用无参数的构造器创建Device匿名实现类的对象
		Device d = new Device() {

			// 初始化块
			{
				System.out.println( "匿名内部类的初始化块..." );
			}

			// 实现抽象方法
			public double getPrice() {

				return 56.2;
			}

			// 重写父类的实例方法
			public String getName() {

				return "键盘";
			}
		};

		ai.test( d );

	}

}
