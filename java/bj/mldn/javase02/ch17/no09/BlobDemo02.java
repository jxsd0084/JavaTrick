package bj.mldn.javase02.ch17.no09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BlobDemo02 {

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
		int               id    = 1;
		String            sql   = "SELECT name,photo FROM userblob WHERE id=?";
		Class.forName( DBDRIVER );    // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		pstmt = conn.prepareStatement( sql );
		pstmt.setInt( 1, id );
		rs = pstmt.executeQuery();    // 执行查询
		if ( rs.next() ) {
			String name = rs.getString( 1 );
			System.out.println( "姓名：" + name );
			InputStream  input = rs.getBinaryStream( 2 );
			File         f     = new File( "d:" + File.separator + "loadmldn.gif" );    // 图片文件
			OutputStream out   = null;
			out = new FileOutputStream( f );
			int temp = 0;
			while ( ( temp = input.read() ) != - 1 ) {    // 边读边写
				out.write( temp );
			}
			input.close();
			out.close();
		}
		pstmt.close();
		conn.close();            // 数据库关闭
	}
}
