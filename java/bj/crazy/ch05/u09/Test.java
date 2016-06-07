package bj.crazy.ch05.u09;

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
class Root {

	static {
		System.out.println( "Root的静态初始化块" );
	}

	{
		System.out.println( "Root的普通初始化块" );
	}

	public Root() {

		System.out.println( "Root的无参数的构造器" );
	}
}

class Mid extends Root {

	static {
		System.out.println( "Mid的静态初始化块" );
	}

	{
		System.out.println( "Mid的普通初始化块" );
	}

	public Mid() {

		System.out.println( "Mid的无参数的构造器" );
	}

	public Mid( String msg ) {
		// 通过this调用同一类中重载的构造器
		this();
		System.out.println( "Mid的带参数构造器，其参数值：" + msg );
	}
}

class Leaf extends Mid {

	static {
		System.out.println( "Leaf的静态初始化块" );
	}

	{
		System.out.println( "Leaf的普通初始化块" );
	}

	public Leaf() {
		// 通过super调用父类中有一个字符串参数的构造器
		super( "Struts2权威指南" );
		System.out.println( "Leaf的构造器" );
	}

}

public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		new Leaf();



		System.out.println();



		new Leaf();

	}
}