package bj.mldn.javase02.ch17.no13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataDemo {

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
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		Connection        conn  = null;        // 数据库连接
		ResultSetMetaData rsmd  = null;        // 数据库元数据
		PreparedStatement pstmt = null;
		Class.forName( DBDRIVER );             // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		String sql = "SELECT id,name,password,age,sex,birthday FROM user";
		pstmt = conn.prepareStatement( sql );  // 实例化对象
		rsmd = pstmt.getMetaData();
		System.out.println( "一共返回" + rsmd.getColumnCount() + "条数据。" );
		if ( rsmd.isAutoIncrement( 1 ) ) {
			System.out.println( rsmd.getColumnName( 1 ) + "列是自动增长的。" );
		}
		conn.close();                          // 数据库关闭
	}
}
