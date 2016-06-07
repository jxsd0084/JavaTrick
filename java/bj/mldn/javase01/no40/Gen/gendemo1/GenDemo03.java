package bj.mldn.javase01.no40.Gen.gendemo1;

public class GenDemo03 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Point p = new Point();

		p.setX( "东经120度" );   // 设置坐标。String --> Object
		p.setY( "北纬230度" );   // 设置坐标。String --> Object

		String x = (String) p.getX();    // 取出X：Object --> String
		String y = (String) p.getY();    // 取出X：Object --> String

		System.out.println( "x = " + x );
		System.out.println( "y = " + y );

	}

}
