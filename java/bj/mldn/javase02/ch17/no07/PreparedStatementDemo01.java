package bj.mldn.javase02.ch17.no07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class PreparedStatementDemo01 {

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
		Connection        conn     = null;        // 数据库连接
		PreparedStatement pstmt    = null;    // 数据库操作
		String            name     = "李兴华";    // 姓名
		String            password = "www.mldnjava.cn";    // 密码
		int               age      = 30;    // 年龄
		String            sex      = "男";     // 性别
		String            birthday = "2007-08-27";    // 生日
		java.util.Date    temp     = null;
		temp = new SimpleDateFormat( "yyyy-MM-dd" ).parse( birthday );
		java.sql.Date bir = new java.sql.Date( temp.getTime() );
		String        sql = "INSERT INTO user(name,password,age,sex,birthday) VALUES (?,?,?,?,?) ";
		Class.forName( DBDRIVER );    // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		pstmt = conn.prepareStatement( sql );    // 实例化PreapredStatement对象
		pstmt.setString( 1, name );
		pstmt.setString( 2, password );
		pstmt.setInt( 3, age );
		pstmt.setString( 4, sex );
		pstmt.setDate( 5, bir );
		int t = pstmt.executeUpdate();    // 执行更新
		System.out.println( t );
		pstmt.close();
		conn.close();            // 数据库关闭
	}
};
