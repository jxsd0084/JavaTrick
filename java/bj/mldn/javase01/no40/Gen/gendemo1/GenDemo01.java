package bj.mldn.javase01.no40.Gen.gendemo1;

public class GenDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Point p = new Point();

		p.setX( 10 ); // 设置坐标。int --> Integer --> Object
		p.setY( 10 ); // 设置坐标。int --> Integer --> Object

		int x = (Integer) p.getX(); // 取出X：Object --> Integer --> int
		int y = (Integer) p.getY(); // 取出X：Object --> Float --> float

		System.out.println( "x = " + x );
		System.out.println( "y = " + y );

	}

}
