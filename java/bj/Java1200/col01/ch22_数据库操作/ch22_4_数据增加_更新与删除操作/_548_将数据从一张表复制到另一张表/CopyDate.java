package bj.Java1200.col01.ch22_数据库操作.ch22_4_数据增加_更新与删除操作._548_将数据从一张表复制到另一张表;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CopyDate {

	private Connection conn;

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

		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return conn; // 返回Connection对象
	}

	public List getExcellenceStu() {

		conn = getConn(); // 获取与数据库的连接
		ResultSet rest;
		List      list = new ArrayList();
		try {
			Statement statement = conn.createStatement(); // 获取Statement对象
			String    sql       = "select * from tb_stu"; // 定义查询语句
			rest = statement.executeQuery( sql ); // 执行查询语句获取查询结果集
			while ( rest.next() ) { // 循环遍历查询结果集
				ExcellenceStu excellenceStu = new ExcellenceStu();
				excellenceStu.setId( rest.getInt( 1 ) );
				excellenceStu.setName( rest.getString( 2 ) );
				excellenceStu.setSex( rest.getString( 3 ) );
				excellenceStu.setSpecialty( rest.getString( 4 ) );
				excellenceStu.setGrade( rest.getString( 5 ) );
				list.add( excellenceStu );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return list; // 返回集合
	}

	public void insertStu( int id ) {

		conn = getConn(); // 获取与数据库的连接
		try {
			Statement statement = conn.createStatement(); // 获取Statement对象
			String sql = "insert into tb_excellenceStu select name,sex,specialty,grade from tb_stu where id = "
					+ id; // 定义插入数据的SQL语句
			statement.executeUpdate( sql ); // 执行插入语句
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}
}
