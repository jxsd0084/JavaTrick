package bj.jakeChen.Guava;

import com.google.common.base.CharMatcher;

/**
 * Created by chenlong on 2016/4/25.
 */
public class TestCharMatcher {

	public static void main( String[] args ) {

		// URL: http://macrochen.iteye.com/blog/737058
/*		assertEquals( "89983", CharMatcher.DIGIT.retainFrom( "some text 89983 and more" ) );
		assertEquals( "some text  and more", CharMatcher.DIGIT.removeFrom( "some text 89983 and more" ) );*/

		System.out.println( "89983".equals( CharMatcher.DIGIT.retainFrom( "some text 89983 and more" ) ) );
		System.out.println( "some text  and more".equals( CharMatcher.DIGIT.removeFrom( "some text 89983 and more" ) ) );

	}

}
