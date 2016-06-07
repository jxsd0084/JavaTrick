package bj.mldn.javase02.ch10.no03;

class Info6 < T, V > {        // 接收两个泛型类型

	private T var;
	private V value;

	public Info6( T var, V value ) {

		this.setVar( var );
		this.setValue( value );
	}

	public void setVar( T var ) {

		this.var = var;
	}

	public void setValue( V value ) {

		this.value = value;
	}

	public T getVar() {

		return this.var;
	}

	public V getValue() {

		return this.value;
	}
};

class Demo6 < S > {

	private S info;

	public Demo6( S info ) {

		this.setInfo( info );
	}

	public void setInfo( S info ) {

		this.info = info;
	}

	public S getInfo() {

		return this.info;
	}
}

public class GenericsDemo31 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Demo6< Info6< String, Integer > > d = null;        // 将Info作为Demo的泛型类型
		Info6< String, Integer >          i = null;        // Info指定两个泛型类型
		i = new Info6< String, Integer >( "李兴华", 30 );   // 实例化Info对象
		d = new Demo6< Info6< String, Integer > >( i );    // 在Demo类中设置Info类的对象
		System.out.println( "内容一：" + d.getInfo().getVar() );
		System.out.println( "内容二：" + d.getInfo().getValue() );

	}

}
