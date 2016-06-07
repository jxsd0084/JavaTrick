package bj.mldn.javase02.ch10.no02;

class Info7 < T extends Number > {    // 此处泛型只能是数字类型

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

public class GenericsDemo19 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info7< Integer > i1 = new Info7< Integer >();        // 声明Integer的泛型对象
	}
}
