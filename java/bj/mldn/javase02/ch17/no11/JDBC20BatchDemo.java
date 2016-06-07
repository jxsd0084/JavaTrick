package bj.mldn.javase02.ch17.no11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC20BatchDemo {

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
		PreparedStatement pstmt = null;
		String            sql   = "INSERT INTO user(name,password,age,sex,birthday) VALUES (?,?,?,?,?)";// 此处不需要设置任何的内容
		Class.forName( DBDRIVER );    // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		pstmt = conn.prepareStatement( sql );    // 表示结果集可以更新
		for ( int i = 0; i < 10; i++ ) {
			pstmt.setString( 1, "李兴华 - " + i );
			pstmt.setString( 2, "MLDN - " + i );
			pstmt.setInt( 3, 20 + i );
			pstmt.setString( 4, "男" );
			pstmt.setDate( 5, new java.sql.Date( new java.util.Date().getTime() ) );
			pstmt.addBatch();    // 加入批处理，等待执行
		}
		int temp[] = pstmt.executeBatch();
		System.out.println( "更新了" + temp.length + "条数据。" );
		pstmt.close();
		conn.close();            // 数据库关闭
	}
}
