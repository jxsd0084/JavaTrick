package bj.crazy.ch13.u04;

import java.sql.*;
import java.util.*;
import java.io.*;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ExecuteSQL {

	private String driver;
	private String url;
	private String user;
	private String pass;
	Connection conn;
	Statement  stmt;
	ResultSet  rs;

	public void initParam( String paramFile ) throws Exception {
		// 使用Properties类来加载属性文件
		Properties props = new Properties();
		props.load( new FileInputStream( paramFile ) );
		driver = props.getProperty( "driver" );
		url = props.getProperty( "url" );
		user = props.getProperty( "user" );
		pass = props.getProperty( "pass" );
	}

	public void executeSql( String sql ) throws Exception {

		try {

			// 加载驱动
			Class.forName( driver );
			// 获取数据库连接
			conn = DriverManager.getConnection( url, user, pass );
			// 使用Connection来创建一个Statment对象
			stmt = conn.createStatement();
			// 执行SQL,返回boolean值表示是否包含ResultSet
			boolean hasResultSet = stmt.execute( sql );
			// 如果执行后有ResultSet结果集
			if ( hasResultSet ) {
				// 获取结果集
				rs = stmt.getResultSet();
				// ResultSetMetaData是用于分析结果集的元数据接口
				ResultSetMetaData rsmd        = rs.getMetaData();
				int               columnCount = rsmd.getColumnCount();
				// 迭代输出ResultSet对象
				while ( rs.next() ) {
					// 依次输出每列的值
					for ( int i = 0; i < columnCount; i++ ) {
						System.out.print( rs.getString( i + 1 ) + "\t" );
					}
					System.out.print( "\n" );
				}
			} else {
				System.out.println( "该SQL语句影响的记录有" + stmt.getUpdateCount() + "条" );
			}
		}
		// 使用finally块来关闭数据库资源
		finally {
			if ( rs != null ) {
				rs.close();
			}
			if ( stmt != null ) {
				stmt.close();
			}
			if ( conn != null ) {
				conn.close();
			}
		}
	}

	/**
	 * 测试
	 * @param args
	 */
	public static void main( String[] args ) throws Exception {

		ExecuteSQL es = new ExecuteSQL();

		es.initParam( "mysql.ini" );

		System.out.println( "------执行删除表的DDL语句-----" );

		es.executeSql( "drop table if exists my_test" );

		System.out.println( "------执行建表的DDL语句-----" );

		es.executeSql( "create table my_test"
		               + "(test_id int auto_increment primary key, "
		               + "test_name varchar(255))" );

		System.out.println( "------执行插入数据的DML语句-----" );

		es.executeSql( "insert into my_test(test_name) "
		               + "select student_name from student_table" );

		System.out.println( "------执行查询数据的查询语句-----" );

		es.executeSql( "select * from my_test" );

	}

}
