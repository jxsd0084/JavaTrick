package bj.jakeChen.Guava;

import com.google.common.base.Strings;

/**
 * Created by chenlong on 2016/4/25.
 */
public class TestIsNullOrEmpty {

	public static void main( String[] args ) {

		// JDK
		String str = "abc";
		if ( str != null && !str.isEmpty() ) {
			System.out.println( "JDK -> " + str );
		} else {
			System.out.println( "str is null or empty" );
		}

		// Guava
		if ( !Strings.isNullOrEmpty( str ) ) {
			System.out.println( "Guava -> " + str );
		} else {
			System.out.println( "str is null or empty" );
		}

	}
}
