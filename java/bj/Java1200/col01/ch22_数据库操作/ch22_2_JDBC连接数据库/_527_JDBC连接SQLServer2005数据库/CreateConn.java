package bj.Java1200.col01.ch22_数据库操作.ch22_2_JDBC连接数据库._527_JDBC连接SQLServer2005数据库;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConn {

	private Connection conn;   //定义Connection对象

	public Connection getConnection() {  //定义连接数据库方法
		try {
			Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );  //加载数据库驱动
			System.out.println( "数据库驱动加载成功！" );
			String url      = "jdbc:sqlserver://localhost:1433;DatabaseName=db_database22";  //定义连接数据库URL
			String userName = "sa";
			String passWord = "";
			conn = DriverManager.getConnection( url, userName, passWord );       //获取数据库连接
			if ( conn != null ) {
				System.out.println( "已成功的与SQLServer2005数据库建立连接！" );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * @param args
	 */

	public static void main( String[] args ) {

		CreateConn conn = new CreateConn();
		conn.getConnection();
	}

}
