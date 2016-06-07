package bj.mldn.javase02.ch17.no07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementDemo02 {

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
		Connection        conn    = null;        // 数据库连接
		PreparedStatement pstmt   = null;    // 数据库操作
		String            keyWord = "李";     // 设置查询关键字
		ResultSet         rs      = null;    // 接收查询结果
		String sql = "SELECT id,name,password,age,sex,birthday " +
		             " FROM user WHERE name LIKE ? OR password LIKE ? OR sex LIKE ?";
		Class.forName( DBDRIVER );    // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		pstmt = conn.prepareStatement( sql );    // 实例化PreapredStatement对象
		pstmt.setString( 1, "%" + keyWord + "%" );
		pstmt.setString( 2, "%" + keyWord + "%" );
		pstmt.setString( 3, "%" + keyWord + "%" );
		rs = pstmt.executeQuery();    // 执行查询
		while ( rs.next() ) {
			int            id   = rs.getInt( 1 );
			String         name = rs.getString( 2 );
			String         pass = rs.getString( 3 );
			int            age  = rs.getInt( 4 );
			String         sex  = rs.getString( 5 );
			java.util.Date d    = rs.getDate( 6 );
			System.out.print( "编号：" + id + "；" );
			System.out.print( "姓名：" + name + "；" );
			System.out.print( "密码：" + pass + "；" );
			System.out.print( "年龄：" + age + "；" );
			System.out.print( "性别：" + sex + "；" );
			System.out.println( "生日：" + d + "；" );
			System.out.println( "-------------------------" );
		}
		rs.close();
		pstmt.close();
		conn.close();            // 数据库关闭
	}
}
