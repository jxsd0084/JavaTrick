package bj.Java1200.col01.ch05_面向对象技术应用.ch05_2_修饰符的使用._088_单例模式的应用;

public class EmperorTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		System.out.println( "创建皇帝1对象：" );
		Emperor emperor1 = Emperor.getInstance();
		emperor1.getName();

		System.out.println( "创建皇帝2对象：" );
		Emperor emperor2 = Emperor.getInstance();
		emperor2.getName();

		System.out.println( "创建皇帝3对象：" );
		Emperor emperor3 = Emperor.getInstance();
		emperor3.getName();

	}

}

