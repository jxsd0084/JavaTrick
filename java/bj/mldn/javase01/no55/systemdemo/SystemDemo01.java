package bj.mldn.javase01.no55.systemdemo;

public class SystemDemo01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		long   begin = System.currentTimeMillis(); // 取得当前时间

		String str   = "";
		for ( int i = 0; i < 10000; i++ ) {

			str += i; // 会产生大量的垃圾
		}

		long end = System.currentTimeMillis(); // 取得当前时间

		System.out.println( end - begin );// 取得计算的时间

	}

}
