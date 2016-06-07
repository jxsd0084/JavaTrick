package bj.powernode.advance.Charpter02;

public class Test2 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		int a = 1;
		int b = 20;

		int sum1 = sum( a, b );
		if ( sum1 != - 1 ) {

			System.out.println( "从" + a + " 到" + b + " 的累加结果是:" + sum1 );
		}

		int score = - 59;
		print( score );

	}

	// 如果一部分代码经常被使用到,可以把这部分代码做出一个方法
	// 该方法可以被重复的调用
	public static void print( int score ) {

		if ( score < 0 ) {
			System.out.println( score + "不是有效的成绩" );
			return;
		}

		if ( score < 60 ) {
			System.out.println( "不及格" );

		} else if ( score < 70 ) {
			System.out.println( "及格" );

		} else if ( score < 90 ) {
			System.out.println( "良" );

		} else {
			System.out.println( "优" );

		}

	}

	// 计算从from到to的累加结果并且返回
	public static int sum( int from, int to ) {

		int sum = 0;
		if ( from > to ) {

			System.out.println( "from必须要小于to" );
			return - 1;
		}


		for ( int i = from; i <= to; i++ ) {

			sum += i;
		}

		return sum;
	}

}
