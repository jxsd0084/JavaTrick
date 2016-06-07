package bj.powernode.basic.day09.exercise;

public class Exercise02 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		// "aaajavabbbjavacccjavasunjavaoraclejavagoodjavaddd"

		String s = " _  javaaaajavabbbjavacccjavasunjavaoraclejavagoodjavajddj";

		// 统计java出现的次数.

		int count = 0;

		for ( int i = 0; i < s.length(); i++ ) {

			if ( i < s.length() - 3 ) { // java.lang.StringIndexOutOfBoundsException

				if ( s.charAt( i ) == 'j' && s.charAt( i + 1 ) == 'a' && s.charAt( i + 2 ) == 'v' && s.charAt( i + 3 ) == 'a' ) {
					count++;

					i += 3;
				}
			}
		}

		System.out.println( "java出现的次数" + count );

	}

}
