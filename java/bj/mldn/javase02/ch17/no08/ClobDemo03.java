package bj.mldn.javase02.ch17.no08;

import java.sql.*;

public class ClobDemo03 {

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
		ResultSet         rs    = null;
		int               id    = 1;        // 读取的编号

		String sql = "SELECT name,note FROM userclob WHERE id=? ";
		Class.forName( DBDRIVER );    // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		pstmt = conn.prepareStatement( sql );    // 创建PreapredStatement对象
		pstmt.setInt( 1, id );
		rs = pstmt.executeQuery();
		if ( rs.next() ) {
			String name = rs.getString( 1 );
			System.out.println( "姓名：" + name );
			Clob   c    = rs.getClob( 2 );
			String note = c.getSubString( 1, (int) c.length() );
			System.out.println( "内容：" + note );
			c.truncate( 100 );    // 只能读100个内容
			System.out.println( "部分读取内容：" + c.getSubString( 1, (int) c.length() ) );
		}
		rs.close();
		pstmt.close();
		conn.close();            // 数据库关闭
	}
}
