package bj.Java1200.col01.ch24_数据库高级应用.ch24_4_使用视图._598_使用视图过滤不想要的数据;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserView {

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

	public List selectView() {

		conn = getConn(); // 获取数据库连接
		Statement cs   = null; // 定义CallableStatement对象
		String    sql  = "Select * from v_laborage"; // 定义查询视图的SQL语句
		List      list = new ArrayList(); // 定义保存查询结果的List集合
		try {
			cs = conn.createStatement(); // 实例化Statement对象
			ResultSet rest = cs.executeQuery( sql ); // 执行SQL语句
			while ( rest.next() ) { // 循环遍历查询结果集
				Laborage laborage = new Laborage();
				laborage.setId( rest.getInt( 1 ) );
				laborage.setName( rest.getString( 2 ) );
				laborage.setDept( rest.getString( 3 ) );
				laborage.setLaborage( rest.getString( 4 ) );
				list.add( laborage );
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return list;
	}
}
