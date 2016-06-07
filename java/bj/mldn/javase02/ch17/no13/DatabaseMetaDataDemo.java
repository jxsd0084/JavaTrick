package bj.mldn.javase02.ch17.no13;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseMetaDataDemo {

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
		Connection       conn = null;        // 数据库连接
		DatabaseMetaData dmd  = null;        // 数据库元数据
		ResultSet        rs   = null;
		Class.forName( DBDRIVER );           // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		dmd = conn.getMetaData();            // 实例化对象
		System.out.println( "数据库名称：" + dmd.getDatabaseProductName() );
		System.out.println( "数据库版本：" + dmd.getDatabaseMajorVersion() + ""
		                    + dmd.getDatabaseMinorVersion() );
		rs = dmd.getPrimaryKeys( null, null, "user" );    // 取得user表的主键
		while ( rs.next() ) {
			System.out.println( "表类别：" + rs.getString( 1 ) );
			System.out.println( "表模式：" + rs.getString( 2 ) );
			System.out.println( "表名称：" + rs.getString( 3 ) );
			System.out.println( "列名称：" + rs.getString( 4 ) );
			System.out.println( "主键序列号：" + rs.getString( 5 ) );
			System.out.println( "主键名称：" + rs.getString( 6 ) );
		}
		conn.close();                        // 数据库关闭
	}
}
