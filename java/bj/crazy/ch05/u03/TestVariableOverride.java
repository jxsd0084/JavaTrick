package bj.crazy.ch05.u03;

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
public class TestVariableOverride {

	// 定义一个name实例属性
	private        String name  = "李刚";

	// 定义一个price类属性
	private static double price = 78.0;






	// 主方法，程序的入口
	public static void main( String[] args ) {

		// 方法里的局部变量，局部变量覆盖成员变量
		int price = 65;

		// 直接访问price变量，将输出price局部变量的值：65
		System.out.println( price );

		// 使用类名来作为price变量的限定，将输出price类属性的值：78.0
		System.out.println( TestVariableOverride.price );

		// 运行info方法
		new TestVariableOverride().info();

	}





	public void info() {

		// 方法里的局部变量，局部变量覆盖成员变量
		String name = "孙悟空";

		// 直接访问name变量，将输出name局部变量的值："孙悟空"
		System.out.println( name );

		// 使用this来作为name变量的限定，将输出price实例属性的值："李刚"
		System.out.println( this.name );

	}

}
