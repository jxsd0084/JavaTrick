package bj.Java1200.col01.ch05_面向对象技术应用.ch05_2_修饰符的使用._089_祖先的止疼药方;

public class Child extends Ancestor {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Child child = new Child();

		System.out.println( "获得祖先的止痒药方：" );
		System.out.println( child.getPrescription() );

	}

}
