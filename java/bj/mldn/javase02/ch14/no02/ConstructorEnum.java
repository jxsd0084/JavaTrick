package bj.mldn.javase02.ch14.no02;

enum Color3 {

	RED( "红色" ), GREEN( "绿色" ), BLUE( "兰色" );

	private Color3( String name ) {

		this.setName( name );
	}

	private String name;            // 定义name属性

	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return this.name;
	}
}

public class ConstructorEnum {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		for ( Color3 c : Color3.values() ) {
			System.out.println( c.ordinal() + " --> " + c.name()
			                    + "(" + c.getName() + ")" );
		}
	}
}
