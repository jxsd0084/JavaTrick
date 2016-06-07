package bj.mldn.javase02.ch10.no01;

class Point {

	private Object x;        // 表示X坐标
	private Object y;        // 表示Y坐标

	public void setX( Object x ) {

		this.x = x;
	}

	public void setY( Object y ) {

		this.y = y;
	}

	public Object getX() {

		return this.x;
	}

	public Object getY() {

		return this.y;
	}
}

public class GenericsDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Point p = new Point();         // 声明一个Point的对象
		p.setX( 10 );                  // 利用自动装箱操作：int --> Integer --> Object
		p.setY( 20 );                  // 利用自动装箱操作：int --> Integer --> Object
		int x = (Integer) p.getX();    // 取出数据先变为Integer，之后自动拆箱
		int y = (Integer) p.getY();    // 取出数据先变为Integer，之后自动拆箱
		System.out.println( "整数表示，X坐标为：" + x );
		System.out.println( "整数表示，Y坐标为：" + y );
	}
}
