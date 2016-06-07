package bj.mldn.javase02.ch10.no02;

class Info5 < T > {

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

public class GenericsDemo17 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info5< Integer > i1 = new Info5< Integer >();        // 声明Integer的泛型对象
		Info5< Float >   i2 = new Info5< Float >();  // 声明Float的泛型对象
		i1.setVar( 30 );                             // 设置整数，自动装箱
		i2.setVar( 30.1f );                          // 设置小数，自动装箱
		fun( i1 );
		fun( i2 );
	}

	public static void fun( Info5< ? extends Number > temp ) {    // 只能接收Number及其Number的子类
		System.out.print( temp + "、" );
	}
}
