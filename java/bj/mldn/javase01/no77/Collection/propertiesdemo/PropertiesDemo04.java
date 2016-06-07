package bj.mldn.javase01.no77.Collection.propertiesdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo04 {

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) {

		Properties pro = new Properties();
		pro.setProperty( "BJ", "BeiJing" );
		pro.setProperty( "NJ", "NanJing" );
		pro.setProperty( "TJ", "TianJin" );
		try {
			pro.storeToXML( new FileOutputStream( new File( "d:" + File.separator )
			                                      + "area.xml" ), "Area Info" );
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
}
