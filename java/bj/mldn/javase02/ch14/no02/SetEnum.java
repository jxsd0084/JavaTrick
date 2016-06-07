package bj.mldn.javase02.ch14.no02;

enum Color4 {
	RED, GREEN, BLUE;
	private String name;            // 定义name属性

	public void setName( String name ) {

		switch ( this ) {    // 判断操作的是那个枚举对象
			case RED: {
				if ( "红色".equals( name ) ) {
					this.name = name;    // 允许设置名字
				} else {
					System.out.println( "设置内容错误。" );
				}
				break;
			}
			case GREEN: {
				if ( "绿色".equals( name ) ) {
					this.name = name;    // 允许设置名字
				} else {
					System.out.println( "设置内容错误。" );
				}
				break;
			}
			case BLUE: {
				if ( "蓝色".equals( name ) ) {
					this.name = name;    // 允许设置名字
				} else {
					System.out.println( "设置内容错误。" );
				}
				break;
			}
		}
		this.name = name;
	}

	public String getName() {

		return this.name;
	}
}

public class SetEnum {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		Color4 c = Color4.BLUE;    // 得到兰色
		c.setName( "兰色" );     // 名字错误
		c.setName( "蓝色" );     // 名字正确
		System.out.println( c.getName() );
	}
}
