package bj.mldn.javase02.ch17.no05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDemo02 {

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
	public static void main( String args[] ) throws Exception {    // 所有的异常抛出
		Connection conn = null;        // 数据库连接
		Statement  stmt = null;            // 数据库操作
		Class.forName( DBDRIVER );    // 加载驱动程序
		String name     = "李康";            // 姓名
		String password = "www.mldnjava.cn";    // 密码
		int    age      = 23;        // 年龄
		String sex      = "女";     // 性别
		String birthday = "2003-08-27";
		String sql = "INSERT INTO user(name,password,age,sex,birthday) " +
		             " VALUES ('" + name + "','" + password + "'," + age + ",'" + sex + "','" + birthday + "')";
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );
		stmt = conn.createStatement();    // 实例化Statement对象
		stmt.executeUpdate( sql );        // 执行数据库更新操作
		stmt.close();                    // 关闭操作
		conn.close();            // 数据库关闭
	}
}

