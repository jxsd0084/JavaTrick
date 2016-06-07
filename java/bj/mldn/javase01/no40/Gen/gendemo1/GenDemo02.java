package bj.mldn.javase01.no40.Gen.gendemo1;

public class GenDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Point p = new Point();

		p.setX( 10.3f );  // 设置坐标。float --> Float --> Object
		p.setY( 10.6f );  // 设置坐标。float --> Float --> Object

		float x = (Float) p.getX();    // 取出X：Object --> Float --> float
		float y = (Float) p.getY();    // 取出X：Object --> Float --> float

		System.out.println( "x = " + x );
		System.out.println( "y = " + y );

	}

}
