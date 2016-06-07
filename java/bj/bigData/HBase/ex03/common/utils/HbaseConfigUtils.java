package bj.bigData.HBase.ex03.common.utils;

import bj.bigData.HBase.ex03.common.constants.TableConstants;
import com.boco.DataPlatform.utils.ConfigUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class HbaseConfigUtils {
	
	private static final String path = TableConstants.PROP_FILE_PATH + "/hbase.properties";
	
	private static Properties  prop;
	private static InputStream inputStream;
	
	// 返回配置对象
	public static Properties getConfigs() {

		if ( prop == null ) {
			init();
		}
		return prop;
	}

	public static void init() {

		prop = new Properties();
		try {
			inputStream = ConfigUtils.class
					.getResourceAsStream( path );
			prop.load( inputStream );
		} catch ( Exception e ) {
			System.out.println( "init properties error: " + path );
			e.printStackTrace();
		} finally {
			if ( inputStream != null ) {
				try {
					inputStream.close();
				} catch ( IOException e ) {
					System.out.println( "can't close the inputstream!" );
					e.printStackTrace();
				}
			}
		}
	}

	public static void main( String[] args ) {

		Enumeration e = getConfigs().keys();
		while ( e.hasMoreElements() ) {
			String k = e.nextElement().toString();
			System.out.println( k + "----" + prop.get( k ) );
		}
	}
}
