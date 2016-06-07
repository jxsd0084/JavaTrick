package bj.Java1200.col01.ch05_面向对象技术应用.ch05_1_Java中类的定义._086_编写同名的方法_方法重载;

public class OverloadingTest {

	public void info() {

		System.out.println( "普通方法：明日科技1岁了！" );
	}

	public void info( int age ) {

		System.out.println( "重载方法：明日科技" + age + "岁了！" );
	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		OverloadingTest ot = new OverloadingTest();

		ot.info();

		for ( int i = 1; i < 5; i++ ) {

			ot.info( i );
		}

	}

}
