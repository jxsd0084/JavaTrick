package bj.powernode.basic.day21.employees_mgt_sys.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 系统语言处理工具
 */
public class LanguageHandlerUtil {

	private static Properties  p;
	private static InputStream in;

	static {
		p = new Properties();
		try {
			in = new FileInputStream( "src/com/dlpowernode/ems/resource/ems_en_US.properties" );
			p.load( in );
		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}

	public static String getContentByKey( String key ) {

		return p.getProperty( key );
	}

	public static void release() {

		if ( in != null ) {
			try {
				in.close();
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
	}
}
