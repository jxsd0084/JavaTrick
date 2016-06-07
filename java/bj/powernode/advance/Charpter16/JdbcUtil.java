package bj.powernode.advance.Charpter16;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {

	// 将Main类中的属性单独抽取出来后作为static静态的属性,方便调用
	private static String url, driver, user, password;

	// 静态初始化块--在类加载的时候初始化
	static {

		// url = "jdbc:oracle:thin:@192.168.1.11:1521:bjpowernode";
		// driver = "oracle.jdbc.OracleDriver";
		// user = "scott";
		// password = "tiger";

		// url1 = "jdbc:mysql://localhost:3306/test";
		// driver1 = "com.mysql.jdbc.Driver";
		// user1 = "root";
		// password1 = "root";

		// url2 = "jdbc:odbc:ORCL_WANGLEI";
		// driver2 = "sun.jdbc.odbc.JdbcOdbcDriver";
		// user2 = "scott";
		// password2 = "tiger";

		// 每个类都有一个class属性,可以通过".class"调用getClassLoader()方法获得类的加载器,
		// getResourceAsStream(String name)--Finds a resource with a given name,
		// return:InputStream.

		InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream(
				"db.properties" );

		// Properties()-- Creates an empty property list with no default values.
		Properties pro = new Properties();
		try {

			// Properties.load(InputStream inStream);
			// --Reads a property list (key and element pairs) from the input
			// byte stream.

			pro.load( in );

			// Properties.getProperty(String key)
			// --Searches for the property with the specified key in this
			// property list.

			url = pro.getProperty( "url" );
			driver = pro.getProperty( "driver" );
			user = pro.getProperty( "user" );
			password = pro.getProperty( "password" );

		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {

			// 最后把流给关闭
			if ( in != null ) {
				try {
					in.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}

	}

	// 将Main类中的getConnection方法抽取出来单独作为一个方法,返回Connection类型
	public static Connection getConnection() {

		// 准备Connection
		Connection conn = null;

		try {
			// Class<?> java.lang.Class.forName(String className)--返回Class对象
			// forName(String className)--返回与带有给定字符串名的类或接口相关联的Class对象。

			Class.forName( driver );

			// getConnection(String url, String user, String password)--Attempts
			// to establish a connection to the given database URL.
			conn = DriverManager.getConnection( url, user, password );
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		return conn;
	}

	// 将关闭数据库的方法单独抽取出来,要求传入参数:ResultSet res, Statement stat, Connection conn
	public static void closeDb( ResultSet res, Statement stat, Connection conn ) {

		// 关闭ResultSet
		if ( res != null ) {
			try {
				res.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}

		// 关闭Statement
		if ( stat != null ) {
			try {
				stat.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}

		// 关闭Connection
		if ( conn != null ) {
			try {
				conn.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
	}

}
