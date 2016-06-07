package bj.mldn.javase02.ch10.no02;

class Info3 < T > {

	private T var;        // 定义泛型变量

	public void setVar( T var ) {

		this.var = var;
	}

	public T getVar() {

		return this.var;
	}

	public String toString() {    // 直接打印
		return this.var.toString();
	}
}

public class GenericsDemo14 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info3< String > i = new Info3< String >();        // 使用String为泛型类型
		i.setVar( "MLDN" );                        // 设置内容
		fun( i );
	}

	public static void fun( Info3< ? > temp ) {    // 可以接收任意的泛型对象
		System.out.println( "内容：" + temp );
	}
}
