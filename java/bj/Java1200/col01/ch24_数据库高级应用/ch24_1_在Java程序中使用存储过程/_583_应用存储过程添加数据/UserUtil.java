package bj.Java1200.col01.ch24_数据库高级应用.ch24_1_在Java程序中使用存储过程._583_应用存储过程添加数据;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserUtil {

	private Connection conn;

	public Connection getConn() {

		try {
			Class.forName( "net.sourceforge.jtds.jdbc.Driver" ); // 加载数据库驱动
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		String url      = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database24"; // 连接数据库URL
		String userName = "sa"; // 连接数据库的用户名
		String passWord = ""; // 连接数据库密码
		try {
			conn = DriverManager.getConnection( url, userName, passWord ); // 获取数据库连接

		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return conn; // 返回Connection对象
	}

	public boolean executeUpdate( User user ) {

		conn = getConn(); // 获取数据库连接
		CallableStatement cs = null; // 定义CallableStatement对象
		String sql = "{call insertUser('" + user.getUserName() + "','"
				+ user.getPassword() + "','" + user.getAge() + "','"
				+ user.getSex() + "','" + user.getJob() + "')}";    //定义调用储存过程的SQL语句
		try {
			cs = conn.prepareCall( sql );     //实例化CallableStatement对象
			cs.executeUpdate();             //执行SQL语句
			return true;
		} catch ( SQLException e ) {
			e.printStackTrace();
			return false;
		}
	}
}
