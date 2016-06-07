package bj.mldn.javase02.ch14.no01;

public class PrintEnum {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		for ( Color c : Color.values() ) {    // 输出枚举中的全部内容
			System.out.println( c );
		}
	}
}
