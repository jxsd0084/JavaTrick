package bj.powernode.advance.Charpter18.src.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


/**
 * util下面的包是"工具包",
 * 老吴将一些重复的代码并且不会影响到其他类的代码抽取出来,
 * 单独地做成一个方法,方便其他的类进行调用
 * <p>
 * 此处的JdbcUtil里面包含的方法有:
 * 1.读取数据库信息的方法,方法名:readdbInfo,静态方法,抛出IO异常
 * 2.获取数据库连接的方法,方法名:getConnection,静态方法,返回类型:Connection,抛出ClassNotFoundException,SQLException,IOException
 * 3.关闭数据库的方法,方法名:closeDb,静态方法,用try...catch块包围,所以没有异常抛出.
 */

public class JdbcUtil {

	private static String url, driver, user, password;
	private static boolean infoIsRead = false;

	private static void readDbInfo() throws IOException {

		InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream(
				"db.properties" );
		Properties pro = new Properties();
		try {
			pro.load( in );
			url = pro.getProperty( "url" );
			driver = pro.getProperty( "driver" );
			user = pro.getProperty( "user" );
			password = pro.getProperty( "password" );
		} finally {
			if ( in != null ) {
				try {
					in.close();
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException, IOException {

		if ( ! infoIsRead ) {
			readDbInfo();
		}

		infoIsRead = true;
		Connection conn = null;
		Class.forName( driver );
		conn = DriverManager.getConnection( url, user, password );
		return conn;
	}

	public static void closeDb( ResultSet res, Statement stat, Connection conn ) {

		if ( res != null ) {
			try {
				res.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}

		if ( stat != null ) {
			try {
				stat.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}

		if ( conn != null ) {
			try {
				conn.close();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
	}

	public static void main( String[] args ) {
		// System.out.println(JdbcUtil.getConnection());
	}
}
