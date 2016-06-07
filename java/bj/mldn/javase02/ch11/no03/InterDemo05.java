package bj.mldn.javase02.ch11.no03;

public class InterDemo05 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		System.out.print( "第一次运行：" );
		Object[] arg1 = { "LXH", "Li", "李兴华" };
		fun( arg1 );                // 传入三个参数



		System.out.print( "\n第二次运行：" );
		Object[] arg2 = { "MLDN" };
		fun( arg2 );                // 传入一个参数



		System.out.print( "\n第三次运行：" );
		Object[] arg3 = {};         // 没有参数传入
		fun( arg3 );


	}

	public static void fun( Object... args ) {    // 固定语法，输入任意多个数据，使用数组表示
		for ( int i = 0; i < args.length; i++ ) {
			System.out.print( args[ i ] + "、" );
		}
	}
}
