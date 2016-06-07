package bj.Java1200.col01.ch24_数据库高级应用.ch24_1_在Java程序中使用存储过程._582_调用存储过程实现用户身份验证;

import java.sql.*;

public class TransferProcure {

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

	public String executeQuery( String userName, String passWord ) {

		String message = "验证失败";            //定义保存返回值的字符串对象
		conn = getConn();                      //获取数据库连接
		CallableStatement cs  = null;            //定义CallableStatement对象
		String            sql = "{call validateSelect('" + userName + "','" + passWord + "')}";    //定义调用存储过程语句
		try {
			cs = conn.prepareCall( sql );         //调用存储过程
			ResultSet rest = cs.executeQuery(); //获取结果集
			while ( rest.next() ) {                 //循环遍历结果集对象
				message = "验证成功";            //设置对象信息
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return message;                          //返回String对象
	}

}
