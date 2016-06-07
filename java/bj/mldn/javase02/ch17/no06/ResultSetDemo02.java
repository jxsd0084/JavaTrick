package bj.mldn.javase02.ch17.no06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetDemo02 {

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
	public static void main( String args[] ) throws Exception {

		Connection conn = null;        // 数据库连接
		Statement  stmt = null;        // 数据库的操作对象
		ResultSet  rs   = null;        // 保存查询结果
		String     sql  = "SELECT id,name,password,age,sex,birthday FROM user";
		Class.forName( DBDRIVER );    // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		stmt = conn.createStatement();
		rs = stmt.executeQuery( sql );
		while ( rs.next() ) {    // 依次取出数据
			int            id       = rs.getInt( 1 );    // 取出id列的内容
			String         name     = rs.getString( 2 );    // 取出name列的内容
			String         password = rs.getString( 3 ); // 取出password列的内容
			int            age      = rs.getInt( 4 );    // 取出age列的内容
			String         sex      = rs.getString( 5 );    // 取出sex列的内容
			java.util.Date d        = rs.getDate( 6 ); // 取出birthday列的内容
			System.out.print( "编号：" + id + "；" );
			System.out.print( "姓名：" + name + "；" );
			System.out.print( "密码：" + password + "；" );
			System.out.print( "年龄：" + age + "；" );
			System.out.print( "性别：" + sex + "；" );
			System.out.println( "生日：" + d + "；" );
			System.out.println( "-----------------------" );
		}
		rs.close();
		stmt.close();
		conn.close();            // 数据库关闭
	}
};
