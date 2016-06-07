package bj.powernode.basic.day07;


/*
	关于java在运行期的命令行参数.
*/
public class _05_TestArray {

	// 主方法
	// main方法中的String[] args中用来接收命令行参数,把命令行参数放入字符串数组中.
	public static void main( String[] args ) {

		// 遍历args
		for ( int i = 0; i < args.length; i++ ) {

			System.out.println( args[ i ] );
		}

	}

}
