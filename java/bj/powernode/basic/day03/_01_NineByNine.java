package bj.powernode.basic.day03;

public class _01_NineByNine {

	/*
	  程序的主方法(入口)
	  public static 是修饰符
	  void 是返回值类型(没有返回值,就是void)
	  main 是方法名
	  String[] args 方法的形式参数列表
	  {} 方法体
	*/
	public static void main( String[] args ) {


		//  纵向循环.
		for ( int i = 1; i <= 9; i++ ) {

			//  打印一行(行号是 i)
			for ( int j = 1; j <= i; j++ ) {

				System.out.print( j + "*" + i + "=" + ( i * j ) + "\t" );
			}

			//  换行
			System.out.print( "\n" );
		}

	}

}
