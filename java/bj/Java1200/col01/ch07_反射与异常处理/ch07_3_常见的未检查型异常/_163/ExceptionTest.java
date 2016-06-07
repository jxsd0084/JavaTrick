package bj.Java1200.col01.ch07_反射与异常处理.ch07_3_常见的未检查型异常._163;

public class ExceptionTest {

	public static void main( String[] args ) {

		Object array[] = new String[ 3 ]; // 声明一个长度为3的Object类型的数组
		array[ 0 ] = new Integer( 1 ); // 将数组的第一个元素赋值为整数对象1
		System.out.println( array[ 0 ] ); // 输出数组的第一个元素
	}
}
