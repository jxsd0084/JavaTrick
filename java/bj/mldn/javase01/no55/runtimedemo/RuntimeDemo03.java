package bj.mldn.javase01.no55.runtimedemo;

public class RuntimeDemo03 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		Runtime run = Runtime.getRuntime(); // 单例设计

		System.out.println( "** 最大的可用内存：" + run.maxMemory() );
		System.out.println( "** 总共内存空间：" + run.totalMemory() );
		System.out.println( "计算前的空闲的内存空间：" + run.freeMemory() );

		String str = "";
		for ( int i = 0; i < 10000; i++ ) {

			str += i; // 会产生大量的垃圾
		}
		System.out.println( "计算后的空闲的内存空间：" + run.freeMemory() );

		run.gc(); // 进行垃圾收集

		System.out.println( "垃圾收集之后的空闲的内存空间：" + run.freeMemory() );

	}

}
