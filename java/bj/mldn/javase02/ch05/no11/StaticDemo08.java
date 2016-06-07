package bj.mldn.javase02.ch05.no11;

public class StaticDemo08 {

	public static void main( String args[] ) {

		if ( args.length != 3 ) {        // 输入的参数如果不足3个，则出错
			System.out.println( "输入的参数不足三个，程序退出~" );
			System.exit( 1 );            // 直接退出此程序
		}

		for ( int i = 0; i < args.length; i++ ) {    // 循环输出输入的参数
			System.out.println( "第" + ( i + 1 ) + "个参数：" + args[ i ] );
		}
	}

}
