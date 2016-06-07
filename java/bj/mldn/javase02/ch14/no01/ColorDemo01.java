package bj.mldn.javase02.ch14.no01;

class Color1 {

	public static final Color1 RED   = new Color1( "红色" );    // 定义第一个对象
	public static final Color1 GREEN = new Color1( "绿色" );    // 定义第一个对象
	public static final Color1 BLUE  = new Color1( "蓝色" );    // 定义第一个对象
	private String name;

	private Color1( String name ) {

		this.name = name;
	}

	public void setName( String name ) {

		this.name = name;
	}

	public String getName() {

		return this.name;
	}

	public static Color1 getInstance( int i ) {

		switch ( i ) {
			case 1: {
				return RED;
			}
			case 2: {
				return GREEN;
			}
			case 3: {
				return BLUE;
			}
			default: {
				return null;
			}
		}

	}
}

public class ColorDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Color1 c1 = Color1.RED;    // 取得红色
		System.out.println( c1.getName() );    // 输出名字
		Color1 c2 = Color1.getInstance( 3 );    // 根据编号取得名字
		System.out.println( c2.getName() );
	}
}
