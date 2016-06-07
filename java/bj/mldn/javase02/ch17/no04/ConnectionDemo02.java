package bj.mldn.javase02.ch17.no04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo02 {

	// 定义MySQL的数据库驱动程序
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	// 定义MySQL数据库的连接地址
	public static final String DBURL    = "jdbc:mysql://localhost:3306/mldn";
	// MySQL数据库的连接用户名
	public static final String DBUSER   = "root";
	// MySQL数据库的连接密码
	public static final String DBPASS   = "mysqladmin";

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) {

		Connection conn = null;        // 数据库连接
		try {
			Class.forName( DBDRIVER );    // 加载驱动程序
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		System.out.println( conn );    // 如果此时可以打印表示连接正常
		try {
			conn.close();            // 数据库关闭
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}
}
