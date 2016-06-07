package bj.Java1200.col01.ch05_面向对象技术应用.ch05_4_面向对象的特征._100_计算几何图形的面积;

public class Test100 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Circle circle = new Circle( 1 );
		System.out.println( "图形的名称是：" + circle.getName() );
		System.out.println( "图形的面积是：" + circle.getArea() );

		Rectangle rectangle = new Rectangle( 1, 1 );
		System.out.println( "图形的名称是：" + rectangle.getName() );
		System.out.println( "图形的面积是：" + rectangle.getArea() );

	}

}
