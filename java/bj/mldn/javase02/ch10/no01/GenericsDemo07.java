package bj.mldn.javase02.ch10.no01;

class Point7 < T > {        // 此处可以随便写标识符号，T是type的简称

	private T var;          // var的类型由T指定，即：由外部指定

	public T getVar() {     // 返回值的类型由外部决定
		return var;
	}

	public void setVar( T var ) {    // 设置的类型也由外部决定
		this.var = var;
	}
}

public class GenericsDemo07 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Point7< Integer > p = new Point7< Integer >();    // 里面的var类型为String类型
//		p.setVar("MLDN");                         // 设置字符串
	}
}
