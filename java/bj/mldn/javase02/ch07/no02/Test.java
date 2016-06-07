package bj.mldn.javase02.ch07.no02;

public class Test {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		int x[] = { 1, 2, 3 };    // 定义数组，长度为3
		assert x.length == 0 : "数组长度不为0";    // 此处断言数组的长度为0
	}

}
