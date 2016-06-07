package bj.mldn.javase02.ch10.no02;

class Info6 < T > {

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

public class GenericsDemo18 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info6< String > i1 = new Info6< String >();        // 声明String的泛型对象
		i1.setVar( "hello" );
//		fun(i1);
	}

	public static void fun( Info6< ? extends Number > temp ) {    // 只能接收Number及其Number的子类
		System.out.print( temp + "、" );
	}
}
