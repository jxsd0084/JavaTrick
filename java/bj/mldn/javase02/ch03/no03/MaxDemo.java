package bj.mldn.javase02.ch03.no03;

public class MaxDemo {

	public static void main( String args[] ) {

		int max = 0;    // 保存最大值
		int x   = 3;    // 定义整型变量x
		int y   = 10;
		max = x > y ? x : y;    // 通过三目运算符求出最大值
		System.out.println( "最大值为：" + max );
	}

}
