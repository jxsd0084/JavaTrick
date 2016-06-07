package bj.mldn.javase02.ch17.no11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC20ReadDemo {

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
		String            sql   = "SELECT id,name,password,age,sex,birthday FROM user";// 此处不需要设置任何的内容
		Class.forName( DBDRIVER );    // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		pstmt = conn.prepareStatement( sql,
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY );
		rs = pstmt.executeQuery();    // 查询操作
		System.out.println( "第2条数据：" );
		rs.absolute( 1 );    // 第二条数据
		print( rs, 1 );
		System.out.println( "第1条数据：" );
		rs.beforeFirst();
		print( rs, 1 );
		System.out.println( "第4条数据：" );
		rs.afterLast();// 最后一条数据之后
		print( rs, -1 );
		rs.close();
		pstmt.close();
		conn.close();            // 数据库关闭
	}

	public static void print( ResultSet rs, int re ) throws Exception {

		if ( re > 0 ) {
			rs.next();        // 由前向后
		} else {
			rs.previous();    // 由后向前
		}
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
		System.out.println( "----------------------------" );
	}
}
