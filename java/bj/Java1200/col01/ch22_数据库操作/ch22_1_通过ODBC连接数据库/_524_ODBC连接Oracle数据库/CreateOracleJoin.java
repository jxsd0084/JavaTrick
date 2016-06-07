package bj.Java1200.col01.ch22_数据库操作.ch22_1_通过ODBC连接数据库._524_ODBC连接Oracle数据库;

import java.sql.Connection;
import java.sql.DriverManager;


public class CreateOracleJoin {

	public boolean Connection() {

		try {
			Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );  //加载数据库驱动
			System.out.println( "数据库驱动加载成功！！" );
			Connection con = DriverManager.getConnection( "jdbc:odbc:data", "system", "aaa" );   //获取数据库连接
			if ( con != null ) {        //判断Connection对象是否为空
				System.out.println( "成功的与oracle数据库建立连接！！" );  //给出提示信息
			}
			return true;
		} catch ( Exception e ) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main( String[] args ) {

		CreateOracleJoin createJoin = new CreateOracleJoin();
		createJoin.Connection();
	}

}
