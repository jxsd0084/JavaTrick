package bj.mldn.javase02.ch17.no11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC20UpdateDemo {

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
		Connection        conn  = null;         // 数据库连接
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String            sql   = "SELECT id,name,password,age,sex,birthday FROM user WHERE id=?"; // 此处不需要设置任何的内容
		Class.forName( DBDRIVER );               // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		pstmt = conn.prepareStatement( sql,
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE );    // 表示结果集可以更新
		pstmt.setInt( 1, 4 );
		rs = pstmt.executeQuery();               // 查询操作
		rs.last();                               // 到最后一行

		rs.updateString( "name", "李藏" );        // 设置姓名
		rs.updateString( "password", "lizang" );  // 设置密码
		rs.updateInt( "age", 23 );                // 设置要插入的年龄
		rs.updateString( "sex", "女" );           // 设置要插入的性别
		rs.updateDate( "birthday", new java.sql.Date( new java.util.Date().getTime() ) );
		rs.cancelRowUpdates();                    // 取消更新
		rs.updateRow();                           // 真正提交数据
		rs.close();
		pstmt.close();
		conn.close();                             // 数据库关闭
	}
}
