package bj.jakeChen.DataBase.SQL;

import java.sql.*;

/**
 * Created by chenlong on 2016/4/28.
 */
public class TestMySQL {

	public static void main( String[] args ) {
		Connection conn     = null;
		Statement  stmt     = null;
		ResultSet  rs       = null;
		String     url      = null;
		String     user     = null;
		String     password = null;
		String     sql      = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
			System.out.println( "驱动加载错误" );
			e.printStackTrace();
		}
		try {
			url = "jdbc:mysql://172.31.101.12:3306/drelephant?characterEncoding=UTF-8";
			user = "fs";
			password = "fsxiaoke";

			conn = DriverManager.getConnection( url, user, password );
		} catch ( SQLException e ) {
			System.out.println( "数据库链接错误" );
			e.printStackTrace();
		}
		try {
			DatabaseMetaData metaData = conn.getMetaData();
			rs = metaData.getTables( null, null, "%", null );
			while ( rs.next() ) {
				System.out.println( rs.getString( "TABLE_NAME" ) );
			}
		} catch ( SQLException e ) {
			System.out.println( "数据操作错误" );
			e.printStackTrace();
		}
		try {
			if ( rs != null ) {
				rs.close();
				rs = null;
			}
			if ( stmt != null ) {
				stmt.close();
				stmt = null;
			}
			if ( conn != null ) {
				conn.close();
				conn = null;
			}
		} catch ( Exception e ) {
			System.out.println( "数据库关闭错误" );
			e.printStackTrace();
		}
	}
}
