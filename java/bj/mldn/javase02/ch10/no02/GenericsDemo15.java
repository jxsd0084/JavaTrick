package bj.mldn.javase02.ch10.no02;

class Info4 < T > {

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

public class GenericsDemo15 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info4< ? > i = new Info4< String >();        // 使用String为泛型类型
//		i.setVar("MLDN");                            // 设置内容
	}
}
