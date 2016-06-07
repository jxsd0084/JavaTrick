package bj.Java1200.col01.ch05_面向对象技术应用.ch05_1_Java中类的定义._083_自定义图书类;

public class BookTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		Book book = new Book( "《Java从入门到精通（第2版）》", "明日科技", 59.8 );
		System.out.println( "书名：" + book.getTitle() );
		System.out.println( "作者：" + book.getAuthor() );
		System.out.println( "价格：" + book.getPrice() + "元" );
	}

}
