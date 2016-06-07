package bj.Java1200.col01.ch22_数据库操作.ch22_2_JDBC连接数据库._526_JDBC连接MySQL数据库;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateMySQL {

	Connection conn = null;

	public Connection getConnection() {

		try {
			Class.forName( "com.mysql.jdbc.Driver" ); // 加载MySQL数据库驱动
			System.out.println( "数据库驱动加载成功！！" );
			String url      = "jdbc:mysql://localhost:3306/db_database22"; // 定义与连接数据库的url
			String user     = "root"; // 定义连接数据库的用户名
			String passWord = "111"; // 定义连接数据库的密码
			conn = DriverManager.getConnection( url, user, passWord ); // 连接连接
			System.out.println( "已成功的与MySQL数据库建立连接！！" );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main( String[] args ) {

		CreateMySQL mySQL = new CreateMySQL();
		mySQL.getConnection();
	}
}
