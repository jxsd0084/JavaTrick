package bj.powernode.basic.day02;

public class _05_Lab {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		//  三目运算符

		//  x?y:z
		//  如果x为true,执行表达式y,如果x为false,执行表达式z

		int score = 80;

		String result = ( score < 60 ? "不及格" : "及格" );

		System.out.println( result );


	}

}
