package bj.mldn.javase02.ch17.no08;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ClobDemo02 {

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
			String       name = rs.getString( 1 );
			StringBuffer note = new StringBuffer();
			System.out.println( "姓名：" + name );
			InputStream input = rs.getAsciiStream( 2 );
			Scanner     scan  = new Scanner( input );    // 使用Scanner类读取内容
			scan.useDelimiter( "\r\n" );    // 将文件换行作为分割符
			while ( scan.hasNext() ) {
				note.append( scan.next() ).append( "\n" );
			}
			System.out.println( "内容：" + note );
			input.close();
		}
		rs.close();
		pstmt.close();
		conn.close();            // 数据库关闭
	}
}
