package bj.bigData.Hive.TestHive2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HiveJdbcClient2 {
	
	//	private static String driverName = "com.cloudera.hive.jdbc41.HS2Driver";
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	private static String url        = "jdbc:hive2://172.31.107.11:10000/test";
	private static String user       = "hive";
	private static String password   = "mysql";
	private static String sql        = "";
	private static ResultSet res;

	public static void main( String[] args ) throws Exception {

		Class.forName( driverName );
		Connection conn = DriverManager.getConnection( url, user, password );
		System.out.println( " conn -> " + conn );
		Statement stmt = conn.createStatement();
		System.out.println( " stmt -> " + stmt );
		
		// 执行“show tables”操作
		sql = "show tables";
		System.out.println( "Running: " + sql );
		res = stmt.executeQuery( sql );

		System.out.println( "执行 “" + sql + "” 运行结果:" );
		while ( res.next() ) {
			System.out.println( res.getString( 1 ) );
		}

		conn.close();
		conn = null;

	}

}
