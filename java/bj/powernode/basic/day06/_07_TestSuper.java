
package bj.powernode.basic.day06;


// 如果一个类没有显示的去extends另外一个类，那么该类会默认继承java.lang.Object 这个类.

// java.lang.Object;是所有类的祖宗类. 是一个顶点. java.lang.Object类没有父类.

public class _07_TestSuper extends Object {  //父类

	int i;
	int k;

	//  定义构造方法
	public _07_TestSuper() {

	}

	public _07_TestSuper( int i, int k ) {

		//  默认有一个
		super(); // java.lang.Object类无参构造方法.

		this.i = i;
		this.k = k;

		System.out.println( "_07_TestSuper(int i,int k) 构造方法调用." );
	}


}


// 子类
class _08_TestSuper extends _07_TestSuper {

	//  构造方法
	public _08_TestSuper() {

	}


	public _08_TestSuper( int i, int k ) {

		//  调用父类对象的构造方法创建父类对象.
		super( i, k );
	}

	//  主程序
	public static void main( String[] args ) {

		//  创建子类对象
		_08_TestSuper t = new _08_TestSuper( 10, 20 );

	}

}
