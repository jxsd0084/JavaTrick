package bj.powernode.basic.day15.枚举类型;

public class Test {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) {

		Season s1 = Season.SPRING;  // s 就是春天  s是一个值. s这个值是一个枚举类型.
		Season s2 = Season.SUMMER;
		Season s3 = Season.AUTUMN;
		Season s4 = Season.WINTER;



		System.out.println( s1.toString() );
		System.out.println( s2.toString() );
		System.out.println( s3.toString() );
		System.out.println( s4.name() );


	}

}
