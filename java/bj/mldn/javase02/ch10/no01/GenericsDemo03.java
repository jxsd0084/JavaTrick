package bj.mldn.javase02.ch10.no01;

class Point3 {

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

public class GenericsDemo03 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		Point3 p = new Point3();         // 声明一个Point的对象
		p.setX( "东经180度" );            // String --> Object
		p.setY( "北纬210度" );            // String --> Object
		String x = (String) p.getX();    // 取出数据先变为Integer，之后自动拆箱
		String y = (String) p.getY();    // 取出数据先变为Integer，之后自动拆箱
		System.out.println( "字符串表示，X坐标为：" + x );
		System.out.println( "字符串表示，Y坐标为：" + y );
	}
}
