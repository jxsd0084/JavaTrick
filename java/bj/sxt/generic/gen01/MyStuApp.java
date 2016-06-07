package bj.sxt.generic.gen01;

/**
 * 自定义泛型类的使用，
 * 在声明时指定具体的类型，
 * 不能为基本类型
 *
 * @author com.bj.com.bj
 */
public class MyStuApp {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		// MyStudent<int> stu = new MyStudent<int>();
		MyStudent< Integer > stu = new MyStudent< Integer >();

		// 1、安全:类型检查
		// stu.setJavase("优秀");
		stu.setJavase( 80 );

		// 2、省心:自动类型转换，免去了类型检查
		Integer score = stu.getJavase();
		System.out.println( score );

	}

}
