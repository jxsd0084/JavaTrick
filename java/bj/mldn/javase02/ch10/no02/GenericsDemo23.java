package bj.mldn.javase02.ch10.no02;

class Info11 < T > {

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

public class GenericsDemo23 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info11< String > i1 = new Info11< String >();        // 泛型类型为String
		Info11< Object > i2 = null;
//		i2 = i1;
	}
}
