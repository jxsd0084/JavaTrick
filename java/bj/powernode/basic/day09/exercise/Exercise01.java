package bj.powernode.basic.day09.exercise;

public class Exercise01 {

	/**
	 * 测试
 	 * @param args
	 */
	public static void main( String[] args ) {

		// A b C def_123AbEF kj k =k,

		String s = "A b C def_123AbEF kj k =k,";

		int upperCount = 0; // 大写计数
		int lowerCount = 0; // 小写计数
		int otherCount = 0; // 非英文字母数

		for ( int i = 0; i < s.length(); i++ ) {

			char c = s.charAt( i );

			if ( c >= 'A' && c <= 'Z' ) {
				upperCount++;

			} else if ( c >= 'a' && c <= 'z' ) {
				lowerCount++;

			} else {

				otherCount++;
			}

		}

		System.out.println( "大写英文字母数=" + upperCount );

		System.out.println( "小写英文字母数=" + lowerCount );

		System.out.println( "非英文字母数="   + otherCount );

	}

}
