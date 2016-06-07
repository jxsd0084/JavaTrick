package bj.mldn.javase02.ch10.no03;

interface Info2 < T > {        // 在接口上定义泛型

	public T getVar();          // 定义抽象方法，抽象方法的返回值就是泛型类型
}

class InfoImpl3 implements Info2< String > {    // 定义泛型接口的子类

	private String var;                         // 定义属性

	public InfoImpl3( String var ) {            // 通过构造方法设置属性内容
		this.setVar( var );
	}

	public void setVar( String var ) {

		this.var = var;
	}

	public String getVar() {

		return this.var;
	}
}

public class GenericsDemo25 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String arsg[] ) {

		Info2 i = null;                  // 声明接口对象
		i = new InfoImpl3( "李兴华" );    // 通过子类实例化对象
		System.out.println( "内容：" + i.getVar() );
	}

}
