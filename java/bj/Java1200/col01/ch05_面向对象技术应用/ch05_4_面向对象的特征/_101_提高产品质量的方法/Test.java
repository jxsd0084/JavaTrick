package bj.Java1200.col01.ch05_面向对象技术应用.ch05_4_面向对象的特征._101_提高产品质量的方法;

public class Test {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Box box = new Box();
		System.out.println( "将箱子的长度设置成-1" );

		box.setLength( -1 );
		System.out.println( "将箱子的宽度设置成-1" );

		box.setWidth( -1 );
		System.out.println( "将箱子的高度设置成-1" );

		box.setHeight( -1 );
		System.out.println( "箱子的长度是：" + box.getLength() );
		System.out.println( "箱子的宽度是：" + box.getWidth() );
		System.out.println( "箱子的高度是：" + box.getHeight() );

	}

}
