package bj.Java1200.col01.ch07_反射与异常处理.ch07_3_常见的未检查型异常._162;

public class ExceptionTest {

	public static void main( String[] args ) {

		System.out.println( "-1.0 / 0 = " + ( - 1.0 / 0 ) );// 演示负浮点数除0
		System.out.println( "+1.0 / 0 = " + ( + 1.0 / 0 ) );// 演示正浮点数除0
		System.out.println( "-1 / 0 = " + ( - 1 / 0 ) );// 演示负整数除0
		System.out.println( "+1 / 0 = " + ( - 1 / 0 ) );// 演示正整数除0
	}
}
