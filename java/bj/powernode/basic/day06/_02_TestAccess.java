package bj.powernode.basic.day06;

//  定义包结构

/*

	java语言中访问控制修饰符.
	
	访问控制修饰符包括四个: public protected default private
	
	这些访问控制修饰符可以用来修饰 (类、方法、变量)
	
	访问控制修饰符从小到大排序： private < default < protected < public
	
	public修饰符: 在任何地方都可以访问.   公开的
	protected 修饰符：可以在本类中进行访问，可以在子类中进行访问，可以在同一个包中进行访问.
	default 修饰符： 在本类中可以访问，同一个包中可以访问。
	private修饰符： 只能在本类进行访问.   私有的
	
	public+protected+default+private 可以修饰变量和方法.
	
	public + default 可以用来修饰类.

*/
public class _02_TestAccess {

	//  private
	private int i1 = 10;


	//  dafault
	int i2 = 20;  //    如果前面没有任何修饰符就代表 default

	//  protected
	protected int i3 = 30;

	//  public
	public int i4 = 40;


	//  程序主方法
	public static void main( String[] args ) {

		_02_TestAccess t = new _02_TestAccess();

		System.out.println( t.i1 );

	}

}

class T01 {

	public static void main( String[] args ) {

		_02_TestAccess t = new _02_TestAccess();

		//  System.out.println(t.i1);   //  在其他类中访问private的变量

		System.out.println( t.i2 );     //  在同一个包下的类可以互相访问 default修饰的变量
	}

}
