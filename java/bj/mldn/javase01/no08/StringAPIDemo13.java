package bj.mldn.javase01.no08;

public class StringAPIDemo13 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String args[] ) {

		String str = "a.a@Aacom";

		System.out.println( validate( str ) );

	}

	public static boolean validate( String email ) {

		boolean flag = true;
		if ( email.indexOf( "@" ) == - 1 || email.indexOf( "" ) == - 1 ) {

			flag = false;
		}

		if ( flag ) {

			if ( ! ( email.indexOf( "@" ) < email.indexOf( "" ) ) ) {

				flag = false;
			}
		}
		return flag;
	}

}
