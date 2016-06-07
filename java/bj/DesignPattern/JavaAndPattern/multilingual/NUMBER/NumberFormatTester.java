package bj.DesignPattern.JavaAndPattern.multilingual.NUMBER;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTester {

	static public void displayNumber( Double amount, Locale currentLocale ) {

		NumberFormat formatter;
		String       amountOut;

		formatter = NumberFormat.getNumberInstance( currentLocale );
		amountOut = formatter.format( amount );

		System.out.println( amountOut + "   " + currentLocale.toString() );
	}

	/**
	 * 测试
 	 * @param args
	 */
	static public void main( String[] args ) {
		displayNumber( new Double( 1234567.89 ), new Locale( "en", "US" ) );
		displayNumber( new Double( 1234567.89 ), new Locale( "de", "DE" ) );
		displayNumber( new Double( 1234567.89 ), new Locale( "fr", "FR" ) );
	}

}

