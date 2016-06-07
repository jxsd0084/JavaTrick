package bj.mldn.javase01.no55.runtimedemo;

public class RuntimeDemo02 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		Runtime run = Runtime.getRuntime();         // 单例设计

		Process pro = run.exec( "freecell.exe" );   // 执行程序

		Thread.sleep( 2000 );                       // 看2秒

		pro.destroy();                              // 销毁

	}

}
