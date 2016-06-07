package bj.Java1200.col01.ch22_数据库操作.ch22_2_JDBC连接数据库._528_JDBC连接Oracle数据库;

import java.sql.*;

public class CreateOracle {

	public Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName( "oracle.jdbc.driver.OracleDriver" );   //加载数据库驱动
			System.out.println( "数据库驱动加载成功！" );           //输出的信息
			String     url      = "jdbc:oracle:thin:@localhost:1521:orcl3";  //获取连接URL
			String     user     = "system";                     //连接用户名
			String     password = "aaa";                    //连接密码
			Connection con      = DriverManager.getConnection( url, user, password );  //获取数据库连接
			if ( con != null ) {
				System.out.println( "成功的与Oracle数据库建立连接！！" );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return conn;        //返回Connection实例
	}

	public static void main( String[] args ) {

		CreateOracle oracle = new CreateOracle();
		oracle.getConnection();
	}
}
