package bj.Java1200.col01.ch23_数据查询.ch23_1_使用子查询._557_使用IN谓词限定查询范围;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConditionUseIn {

	private Connection conn; // 定义Connection对象

	public Connection getConn() {

		try {
			Class.forName( "net.sourceforge.jtds.jdbc.Driver" ); // 加载数据库驱动
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		String url      = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database23"; // 连接数据库URL
		String userName = "sa"; // 连接数据库的用户名
		String passWord = ""; // 连接数据库密码
		try {
			conn = DriverManager.getConnection( url, userName, passWord ); // 获取数据库连接

		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return conn; // 返回Connection对象
	}
	//定义用子查询作为派生的表方法

	public List getSubTable( int lab1, int lab2 ) {

		List list = new ArrayList< Emp >(); // 定义List集合对象
		conn = getConn(); // 获取与数据库的连接
		try {
			Statement statement = conn.createStatement(); // 获取Statement对象
			String sql = "select * from tb_emp where laborage in (select laborage from tb_emp " +
					"where laborage between " + lab1 + " and  " + lab2 + ")"; // 定义查询语句
			ResultSet rest = statement.executeQuery( sql ); // 执行查询语句获取查询结果集
			while ( rest.next() ) { // 循环遍历查询结果集
				Emp emp = new Emp(); // 定义于数据表对应的JavaBean对象
				emp.setId( rest.getInt( 1 ) ); // 设置对象属性
				emp.setName( rest.getString( 2 ) );
				emp.setDept( rest.getString( 3 ) );
				emp.setHeadship( rest.getString( 4 ) );
				emp.setJoinDate( rest.getString( 5 ) );
				emp.setLaborage( rest.getFloat( 6 ) );
				list.add( emp ); // 将对象添加到集合中
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return list; // 返回查询结果
	}


}
