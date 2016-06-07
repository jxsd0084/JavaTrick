package bj.mldn.javase02.ch10.no02;

class Info2 < T > {

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

public class GenericsDemo13 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info2< String > i = new Info2< String >();        // 使用String为泛型类型
		i.setVar( "MLDN" );                        // 设置内容
		fun( i );
	}

	public static void fun( Info2 temp ) {        // 接收Object泛型类型的Info对象
		System.out.println( "内容：" + temp );
	}
}
