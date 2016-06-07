package bj.Java1200.col01.ch05_面向对象技术应用.ch05_2_修饰符的使用._090_统计图书的销售量;

public class Book {

	private static int counter = 0;

	public Book( String title ) {

		System.out.println( "售出图书：" + title );
		counter++;
	}

	public static int getCounter() {

		return counter;
	}

}
