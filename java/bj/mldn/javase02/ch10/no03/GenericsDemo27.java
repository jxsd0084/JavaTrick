package bj.mldn.javase02.ch10.no03;

class Info3 < T extends Number > {    // 指定上限，只能是数字类型

	private T var;                    // 此类型由外部决定

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

public class GenericsDemo27 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Info3< Integer > i = fun( 30 );
		System.out.println( i.getVar() );
	}

	public static < T extends Number > Info3< T > fun( T param ) {

		Info3< T > temp = new Info3< T >();   // 根据传入的数据类型实例化Info
		temp.setVar( param );                 // 将传递的内容设置到Info对象的var属性之中
		return temp;                          // 返回实例化对象
	}

}
