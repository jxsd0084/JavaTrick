package bj.Java1200.col01.ch22_数据库操作.ch22_4_数据增加_更新与删除操作._547;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertString {

	private Connection conn;

	// 获取数据库连接
	public Connection getConn() {

		try {
			Class.forName( "net.sourceforge.jtds.jdbc.Driver" ); // 加载数据库驱动
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		String url      = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database22"; // 连接数据库URL
		String userName = "sa"; // 连接数据库的用户名
		String passWord = ""; // 连接数据库密码
		try {
			conn = DriverManager.getConnection( url, userName, passWord ); // 获取数据库连接
			if ( conn != null ) {
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return conn; // 返回Connection对象
	}

	public void insertUsers( String name, String loves ) {

		conn = getConn(); // 获取数据库连接
		try {
			PreparedStatement statement = conn
					.prepareStatement( "insert into tb_users values(?,?)" ); // 定义插入数据库的预处理语句
			statement.setString( 1, name );
			statement.setString( 2, loves );
			statement.executeUpdate(); // 执行预处理语句
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}
}
