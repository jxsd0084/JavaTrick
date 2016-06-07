package bj.powernode.advance.Charpter19.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {

	private static String url, driver, user, password;
	private static boolean infoIsRead = false;

	private static void readDbInfo() throws IOException {

		InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream(
				"db.properties" );
		Properties pro = new Properties();
		try {
			pro.load( in );
			url = pro.getProperty( "url" );
			driver = pro.getProperty( "driver" );
			user = pro.getProperty( "user" );
			password = pro.getProperty( "password" );
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

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException, IOException {

		if ( ! infoIsRead ) {
			readDbInfo();
		}

		infoIsRead = true;
		Connection conn = null;
		Class.forName( driver );
		conn = DriverManager.getConnection( url, user, password );
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

	public static void main( String[] args ) {
		// System.out.println(JdbcUtil.getConnection());
	}
}
