package bj.powernode.advance.Charpter10.test1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {

	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main( String[] args ) {




		Date date = new Date();
		System.out.println( date );
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss E" );
		String           s      = format.format( date );
		System.out.println( s );






		// String => Date
		String           s2      = "1980-12-23";
		SimpleDateFormat format2 = new SimpleDateFormat( "yyyy-MM-dd" );
		try {
			Date date2 = format2.parse( s2 );
			System.out.println( date2 );
		} catch ( ParseException e ) {

			e.printStackTrace();
		}






		Date date3 = new Date( System.currentTimeMillis() );
		System.out.println( date3 );

		long startTime = System.currentTimeMillis();
		for ( int i = 0; i < 100000; i++ ) {
			System.out.println( "==========" );
		}
		long endTime = System.currentTimeMillis();


		System.out.println( "程序运行了:" + ( endTime - startTime ) );


		String           s3      = "1980-12-23";
		String           s4      = "2000-12-12";
		SimpleDateFormat format4 = new SimpleDateFormat( "yyyy-MM-dd" );





		try {

			Date d1 = format4.parse( s3 );
			Date d2 = format4.parse( s4 );

			long l = ( d2.getTime() - d1.getTime() ) / 1000 / 60 / 60 / 24;

			System.out.println( l );

		} catch ( ParseException e ) {

			// TODO Auto-generated catch blockF
			e.printStackTrace();
		}




	}

}
