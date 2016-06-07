package bj.mldn.javase02.ch17.no10;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class ProcDemo {

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
		CallableStatement cstmt = null;        // 数据库操作
		String            sql   = "{CALL myproc(?,?,?)}";    // 调用过程
		Class.forName( DBDRIVER );    // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		cstmt = conn.prepareCall( sql );
		cstmt.setInt( 1, 70 );    // 设置第一个参数是70
		cstmt.setInt( 2, 80 );    // 设置第二个参数是80
		cstmt.registerOutParameter( 2, Types.INTEGER );
		cstmt.registerOutParameter( 3, Types.INTEGER );
		cstmt.execute();        // 执行过程
		System.out.println( "INOUT的返回值：" + cstmt.getInt( 2 ) );
		System.out.println( "OUT的返回值：" + cstmt.getInt( 3 ) );
		cstmt.close();
		conn.close();            // 数据库关闭
	}
}
