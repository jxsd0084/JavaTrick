package bj.mldn.javase02.ch10.no03;

class Info4 < T > {    // 指定上限，只能是数字类型

	private T var;        // 此类型由外部决定

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

public class GenericsDemo28 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info4< String > i1 = new Info4< String >();
		Info4< String > i2 = new Info4< String >();
		i1.setVar( "HELLO" );        // 设置内容
		i2.setVar( "李兴华" );        // 设置内容
		add( i1, i2 );
	}

	public static < T > void add( Info4< T > i1, Info4< T > i2 ) {

		System.out.println( i1.getVar() + " " + i2.getVar() );
	}

}
