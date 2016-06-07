package bj.mldn.javase01.no91.JDBC.mysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDBCMySQL {

	// 驱动程序就是之前在classpath中配置的jdbc的驱动程序的jar包中
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	// 连接地址是由各个数据库生产商单独提供的，所以需要单独记住
	public static final String DBURL    = "jdbc:mysql://localhost:3306/mldn";
	// 连接数据库的用户名
	public static final String DBUSER   = "root";
	// 连接数据库的密码
	public static final String DBPASS   = "mysqladmin";

	public static void main(String[] args) throws Exception {

		Connection        conn   = null; // 表示数据库的连接的对象
		PreparedStatement pstmt  = null; // 表示数据库的更新操作
		String            name   = "张三";
		int               age    = 30;
		Date              date   = new SimpleDateFormat("yyyy-MM-dd").parse("1983-02-15");
		float             salary = 7000.0f;
		String            sql    = "INSERT INTO person(name,age,birthday,salary) VALUES (?,?,?,?) ";
		System.out.println(sql);
		// 1、使用Class类加载驱动程序
		Class.forName(DBDRIVER);
		// 2、连接数据库
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		// 3、PreparedStatement接口需要通过Connection接口进行实例化操作
		pstmt = conn.prepareStatement(sql);// 使用预处理的方式创建对象
		pstmt.setString(1, name);// 第一个？号的内容
		pstmt.setInt(2, age);    // 第二个？号的内容
		pstmt.setDate(3, new java.sql.Date(date.getTime()));
		pstmt.setFloat(4, salary);
		// 执行SQL语句，更新数据库
		pstmt.executeUpdate();
		// 4、关闭数据库 
		pstmt.close();
		conn.close();
	}
}
