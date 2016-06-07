package bj.powernode.basic.day01;

public class TestZhuanYi {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		char c1 = 'n';

		System.out.println( c1 );





		char c2 = '\n';  // 转义

		System.out.println( c2 );





		System.out.println( "Test Zhuan Yi." );
		
		/*
			System.out.println()    和System.out.print()区别.
			System.out.println()    打印之后换行.
			System.out.print()      打印之后不换行
		*/



		System.out.println( "**********" );
		System.out.print( "&&&&&&&&&&&" );






		char c3 = '\t';
		System.out.print( c3 );
		System.out.println( "%%%%%%%%%%%" );

		// \\t 制表符(tab键)  \\n 换行   \\u 指定后面的数据是一个Unicode编码

	}

}
