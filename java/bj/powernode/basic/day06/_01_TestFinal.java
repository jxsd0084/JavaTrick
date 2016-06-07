

//  定义包结构
package bj.powernode.basic.day06;


/*

	final关键字.(最终的)
	
	final关键字可以用在哪里？
	
		1.final可以用来修饰成员变量
			final如果修饰了成员变量，那么成员变量的值就不能再改变了。
			
		2.final可以用来修饰一个方法.
			final如果修饰了一个方法，那么该方法就不能被重写了。
			
		3.final可以用来修饰一个类.
			final如果修饰了一个类，那么这个类就不能被继承了。

*/
public class _01_TestFinal {

	//  final修饰成员变量
	final int i = 10;

	//  注意: 修饰成员变量的 final 通常和 static 一起出现.
	static final int k = 100;               //   k 值不能被改变的变量.  常量


	//  修改i的方法
	public void changeI() {
		//  i ++;  //   error.
	}

	public void changeNum( final int k ) {  //  k一旦被赋值，则不能被改变.
		//  只能读取k，但是不能修改k的值.
		//  k 是只读的
		//  k = 10;
	}


	public final void m() {

		System.out.println( "final m method invoked!" );
	}


	//  程序的入口
	public static void main( String[] args ) {

		_01_TestFinal t = new _01_TestFinal();

		t.changeNum( 11 );

	}

}


class Sub_01_TestFinal extends _01_TestFinal {

	//  重写父类的m方法.注意：父类的m方法是final的.
	//  public void m(){
	//  	System.out.println("Sub_01_TestFinal final m method invoked!");
	//  }

}


//  final的类不能被继承.
final class T {

}

//  class TT extends T{}
