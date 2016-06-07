package bj.mldn.javase01.no91.JDBC.connectdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectJDBC {

	// 驱动程序就是之前在classpath中配置的jdbc的驱动程序的jar包中
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	// 连接地址是由各个数据库生产商单独提供的，所以需要单独记住
	public static final String DBURL    = "jdbc:oracle:thin:@localhost:1521:MLDN";
	// 连接数据库的用户名
	public static final String DBUSER   = "scott";
	// 连接数据库的密码
	public static final String DBPASS   = "tiger";

	public static void main(String[] args) throws Exception {

		Connection conn = null; // 表示数据库的连接的对象
		// 1、使用Class类加载驱动程序
		Class.forName(DBDRIVER);
		// 2、连接数据库
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		System.out.println(conn);
		// 4、关闭数据库
		conn.close();
	}

}
