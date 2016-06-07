package bj.mldn.javase02.ch10.no01;

class Info < T > {

	private T var;

	public T getVar() {

		return this.var;
	}

	public void setVar( T var ) {

		this.var = var;
	}

	public String toString() {        // 覆写Object类中的toString()方法
		return this.var.toString();
	}
}

public class GenericsDemo10 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info i = new Info();           // 警告，没有指定泛型类型
		i.setVar( "MLDN" );            // 设置字符串
		System.out.println( "内容：" + i.getVar() );
	}
}
