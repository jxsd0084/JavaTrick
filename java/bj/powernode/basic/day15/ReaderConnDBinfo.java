package bj.powernode.basic.day15;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReaderConnDBinfo {

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String[] args ) throws Exception {

		// 1.创建属性对象
		Properties p = new Properties();

		// 2.加载资源文件.(属性文件)
		InputStream in = new FileInputStream( "D:/course/JavaProjects/day15/connDBinfo.properties" );
		p.load( in );


		// 3.通过key获取value
		String username        = p.getProperty( "username" ); // key不能随意写,来自属性文件的key
		String connUrl         = p.getProperty( "url" );
		String password        = p.getProperty( "password" );
		String driverClassName = p.getProperty( "driverClassName" );


		System.out.println( username );
		System.out.println( password );
		System.out.println( connUrl );
		System.out.println( driverClassName );

		// 4.关闭流
		in.close();


	}

}
