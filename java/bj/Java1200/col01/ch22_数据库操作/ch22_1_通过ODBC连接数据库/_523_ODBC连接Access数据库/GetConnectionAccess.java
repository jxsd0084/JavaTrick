package bj.Java1200.col01.ch22_数据库操作.ch22_1_通过ODBC连接数据库._523_ODBC连接Access数据库;

import java.sql.*;

public class GetConnectionAccess {

	public boolean Connection() {

		try {
			Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );  //加载数据库驱动
			Connection con = DriverManager.getConnection( "jdbc:odbc:access" );   //获取数据库连接
			if ( con != null ) {
				System.out.println( "通过JDBC-ODBC桥连接Access数据库" );
			}
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main( String[] args ) {

		GetConnectionAccess access = new GetConnectionAccess();
		access.Connection();
	}
}
