package bj.mldn.javase01.no40.Gen.gendemo4;

public class GenDemo07 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Info< String > info1 = new Info< String >( "张三" );

		Info< Object > info2 = new Info< Object >( 1 );

		fun( info1 );
		fun( info2 );

	}

	public static void fun( Info< ? super String > x ) {    // 只能接收String或其父类

		System.out.println( x.getMsg() );
	}
}
