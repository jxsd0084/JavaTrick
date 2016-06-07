package bj.mldn.javase01.no40.Gen.gendemo2;

public class GenDemo05 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Point< Integer > p = new Point< Integer >();

		p.setX( 10 );        // 设置坐标。int --> Integer --> Object
		p.setY( 10 );        // 设置坐标。int --> Integer --> Object

		int x = p.getX();    // 取出X：Object --> Integer --> int
		int y = p.getY();    // 取出X：Object --> Float --> float

		System.out.println( "x = " + x );
		System.out.println( "y = " + y );

	}

}
