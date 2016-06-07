package bj.mldn.javase02.ch10.no02;

class Info10 < T > {

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

public class GenericsDemo22 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info10< Integer > i1 = new Info10< Integer >();        // 声明Integer的泛型对象
		i1.setVar( 30 );
//		fun(i1);
	}

	public static void fun( Info10< ? super String > temp ) {    // 只能接收String或Object类型的泛型
		System.out.print( temp + "、" );
	}
}
