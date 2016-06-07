package bj.mldn.javase01.no55.runtimedemo;

public class RuntimeDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		Runtime run = Runtime.getRuntime(); // 单例设计

		run.exec( "freecell.exe" );           // 执行程序
	}

}
