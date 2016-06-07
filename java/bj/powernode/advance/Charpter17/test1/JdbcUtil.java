package bj.powernode.advance.Charpter17.test1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {

	private static String url, driver, user, password;

	static {
		// url = "jdbc:oracle:thin:@192.168.1.11:1521:bjpowernode";
		// driver = "oracle.jdbc.OracleDriver";
		// user = "scott";
		// password = "tiger";

		// url1 = "jdbc:mysql://localhost:3306/test";
		// driver1 = "com.mysql.jdbc.Driver";
		// user1 = "root";
		// password1 = "root";
		//
		// url2 = "jdbc:odbc:ORCL_WANGLEI";
		// driver2 = "sun.jdbc.odbc.JdbcOdbcDriver";
		// user2 = "scott";
		// password2 = "tiger";

		InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream(
				"db.properties" );
		Properties pro = new Properties();
		try {
			pro.load( in );
			url = pro.getProperty( "url" );
			driver = pro.getProperty( "driver" );
			user = pro.getProperty( "user" );
			password = pro.getProperty( "password" );
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			if ( in != null ) {
				try {
					in.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}

	}

	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName( driver );
			conn = DriverManager.getConnection( url, user, password );
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeDb( ResultSet res, Statement stat, Connection conn ) {

		if ( res != null ) {
			try {
				res.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}

		if ( stat != null ) {
			try {
				stat.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}

		if ( conn != null ) {
			try {
				conn.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
	}

}
