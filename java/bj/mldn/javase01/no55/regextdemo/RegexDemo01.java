package bj.mldn.javase01.no55.regextdemo;

public class RegexDemo01 {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {

		String  str  = "121s34123414123";
		char    c[]  = str.toCharArray(); // 将字符串变为字符数组

		boolean flag = true;
		for ( int i = 0; i < c.length; i++ ) {

			if ( ! ( c[ i ] >= '0' && c[ i ] <= '9' ) ) {   // 不是数字

				flag = false;
				break;
			}
		}

		if ( flag ) {
			System.out.println( "字符串是由数字组成！" );

		} else {
			System.out.println( "字符串不是由数字组成！" );
		}

	}

}
