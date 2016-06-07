package bj.mldn.javase02.ch10.no01;

class Point8 < T > {                // 此处可以随便写标识符号，T是type的简称

	private T var;                  // var的类型由T指定，即：由外部指定

	public Point8( T var ) {        // 通过构造方法设置内容
		this.var = var;
	}

	public T getVar() {             // 返回值的类型由外部决定
		return var;
	}

	public void setVar( T var ) {   // 设置的类型也由外部决定
		this.var = var;
	}
}

public class GenericsDemo08 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Point8< String > p = new Point8< String >( "MLDN" );    // 里面的var类型为String类型
		System.out.println( "内容：" + p.getVar() );
	}
}
