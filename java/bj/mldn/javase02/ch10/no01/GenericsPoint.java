package bj.mldn.javase02.ch10.no01;

class Point9 < T > {

	private T x;        // 表示X坐标
	private T y;        // 表示Y坐标

	public void setX( T x ) {

		this.x = x;
	}

	public void setY( T y ) {

		this.y = y;
	}

	public T getX() {

		return this.x;
	}

	public T getY() {

		return this.y;
	}
}

public class GenericsPoint {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Point9< Integer > p = new Point9< Integer >();
		p.setX( 10 );           // 利用自动装箱操作：int --> Integer
//		p.setY("北纬210度");     // 利用自动装箱操作：int --> Integer
		int x = p.getX();       // 自动拆箱
		int y = p.getY();       // 自动拆箱
		System.out.println( "整数表示，X坐标为：" + x );
		System.out.println( "整数表示，Y坐标为：" + y );
	}
}
