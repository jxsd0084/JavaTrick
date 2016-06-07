package bj.Java1200.col01.ch22_数据库操作.ch22_1_通过ODBC连接数据库._522_使用ODBC连接SQLServer数据库;

import java.sql.Connection;
import java.sql.DriverManager;


public class GetConnection {

	private Connection conn;        //定义Connection对象

	public String con() {

		try {
			Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );  //加载ODBC数据库驱动
			conn = DriverManager.getConnection( "jdbc:odbc:db_database22", "sa", "" );  //获取数据库连接
			return "数据库连接成功！";  //返回连接对象
		} catch ( Exception e ) {
			e.printStackTrace();
			return "数据库连接失败！";
		}
	}

	public static void main( String[] args ) {

		GetConnection getConn = new GetConnection();
		System.out.println( getConn.con() );

	}
}
