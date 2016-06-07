
//  定义包结构

package bj.powernode.basic.day06;


/*

	java语言中的super关键字.
	
	this(指向自身对象的引用)
	
	super(指向父类对象的引用)
	
	在java语言中，任何一个子类对象在创建的时候，首先创建父类对象. (没有父亲哪来儿子)  先有父后有子
	
	也就是说：在调用子类的构造方法的时候，父类的构造方法先执行.
	
	
	super关键字可以出现的地方？
	
		1.super关键字可以出现在实例方法中.
			super.methodName();  调用父类对象的方法.
			super.成员变量; 访问父类的成员变量.
	
	
		回顾：this关键字用在构造方法中，完成一个构造方法去调用另一个构造方法	语法 this(参数列表);	
		
		2.super关键字可以出现在子类的构造方法中.去调用父类的构造方法.
			完成创建父类对象的工作.
			语法: super(参数列表);

*/

//  父类
public class _05_TestSuper {

	public int i = 20;


	public void m() {

		System.out.println( "m method invoked!" );
	}


}


// 子类
class _06_TestSuper extends _05_TestSuper {


	//  重写父类中的m方法

	public void m() {

		super.m();  //  在父类对象的基础之上进行重写,扩展重写.
		System.out.println( "_06_TestSuper'm method invoked!" );
	}


	//  完全重写.
	//  public void m(){
	//  	System.out.println("_06_TestSuper'm method invoked!");
	//  }


	public void m2() {

		super.m();
		System.out.println( super.i );
	}


	public static void main( String[] args ) {

		_06_TestSuper t = new _06_TestSuper();
		//  t.m();
		t.m2();

	}

}
