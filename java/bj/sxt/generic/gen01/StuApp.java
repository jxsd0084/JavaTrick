package bj.sxt.generic.gen01;

/**
 * 没有泛型的 类 存储数据 -->麻烦
 *
 * @author com.bj.com.bj
 */
public class StuApp {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {
		// 存入整数 int -->Integer -->Object
		Student stu    = new Student( 80 );
		Object  javase = stu.getJavase();

		// 类型检查  处理转换异常
		if ( javase instanceof Integer ) {
			// 强制类型转换
			Integer javaseScore = (Integer) javase;
		}

		stu = new Student( "优秀" );
		javase = stu.getJavase();
		// 类型检查  处理转换异常
		if ( javase instanceof String ) {
			// 强制类型转换
			String javaseScore = (String) javase;
		}

	}

}
