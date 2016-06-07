package bj.Java1200.col01.ch05_面向对象技术应用.ch05_2_修饰符的使用._091_汉诺塔问题求解;

public class HanoiTower {

	public static void moveDish( int level, char from, char inter, char to ) {

		if ( level == 1 ) {
			System.out.println( "从 " + from + " 移动盘子 1 号到 " + to );

		} else {
			moveDish( level - 1, from, to, inter );
			System.out.println( "从 " + from + " 移动盘子 " + level + " 号到 " + to );
			moveDish( level - 1, inter, from, to );

		}

	}

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		int nDisks = 3;

		moveDish( nDisks, 'A', 'B', 'C' );
	}

}
