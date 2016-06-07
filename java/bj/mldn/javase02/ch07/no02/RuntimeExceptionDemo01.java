package bj.mldn.javase02.ch07.no02;

public class RuntimeExceptionDemo01 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String args[] ) {

		String str  = "123";                    // 定义字符串，全部由数字组成
		int    temp = Integer.parseInt( str );  // 将字符串变为int类型
		System.out.println( temp * temp );      // 计算乘方
	}

}
