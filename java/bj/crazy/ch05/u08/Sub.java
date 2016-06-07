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
class Base {

	public Base() {

		test();
	}

	public void test() {

		System.out.println( "将被子类重写的方法" );
	}
}

class Sub extends Base {

//	private String name;    // 默认: null
	private String name = "SSS";

	public void test() {

		System.out.println( "子类重写父类的方法，其name字符串长度" + name.length() );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		// 下面代码会引发 空指针异常

		Sub s = new Sub();

		/*
			子类调用父类的构造器, 但是子类的属性还没有被初始化, 所有报 空指针异常
		*/
	}

}
