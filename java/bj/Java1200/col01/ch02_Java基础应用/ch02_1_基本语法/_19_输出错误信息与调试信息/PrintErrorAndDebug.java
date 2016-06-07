package bj.Java1200.col01.ch02_Java基础应用.ch02_1_基本语法._19_输出错误信息与调试信息;

/**
 * 019 输出错误信息与调试信息
 */
public class PrintErrorAndDebug {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( "main()方法开始运行了。" );

		// 输出错误信息
		System.err.println( "在运行期间手动输出一个错误信息：" );
		System.err.println( "\t该软件没有买保险，请注意安全" );
		System.out.println( "PrintErrorAndDebug.main()" );
		System.out.println( "main()方法运行结束。" );
	}

}
