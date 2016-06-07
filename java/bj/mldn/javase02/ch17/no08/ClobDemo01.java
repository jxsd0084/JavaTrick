package bj.mldn.javase02.ch17.no08;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ClobDemo01 {

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
		String            name  = "李兴华";    // 表示姓名
		String            sql   = "INSERT INTO userclob(name,note) VALUES (?,?) ";
		Class.forName( DBDRIVER );    // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		pstmt = conn.prepareStatement( sql );    // 创建PreapredStatement对象
		File        f     = new File( "d:" + File.separator + "mldn.txt" );
		InputStream input = null;
		input = new FileInputStream( f );    // 通过输入流读取文件
		pstmt.setString( 1, name );
		pstmt.setAsciiStream( 2, input, (int) f.length() );
		pstmt.executeUpdate();
		conn.close();            // 数据库关闭
	}
}
