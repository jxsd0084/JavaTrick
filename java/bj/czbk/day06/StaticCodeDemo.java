package bj.czbk.day06;

/*


静态代码块。

格式：
static {
	静态代码块中的执行语句。
}

特点：随着类的加载而执行，只执行一次,并优先于主函数。
用于给类进行初始化的。


*/
class StaticCode {

	int num = 9;

	StaticCode() {

		System.out.println( "b" );
	}

	static {
		System.out.println( "a" );
	}

	{
		System.out.println( "c" + this.num );
	}

	StaticCode( int x ) {

		System.out.println( "d" );
	}

	public static void show() {

		System.out.println( "show run" );
	}
}

class StaticCodeDemo {

	static {
		//  System.out.println("b");
	}

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		new StaticCode( 4 );    //  a c d
		//  new StaticCode();
		//  new StaticCode();
		//  System.out.println("over");
		//  StaticCode.show();
		//  StaticCode s = null;
		//  s = new StaticCode();

		//  StaticCode.show();
	}

	static {
		//  System.out.println("c");
	}
}
//  d:\>java0217\day06>java StaticCodeDemo
//  b c a over
