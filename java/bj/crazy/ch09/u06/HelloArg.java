package bj.crazy.ch09.u06;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloArg {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Locale currentLocale = null;

		if ( args.length == 2 ) {
			currentLocale = new Locale( args[ 0 ], args[ 1 ] );

		} else {
			currentLocale = Locale.getDefault();
		}

		ResourceBundle bundle = ResourceBundle.getBundle( "MyResource", currentLocale );

		String         msg    = bundle.getString( "msg" );

		System.out.println( MessageFormat.format( msg, "yeeku", new Date() ) );

	}

}
