package bj.Java1200.col01.ch21_SQL应用.ch21_3_大小比较与逻辑应用._520_格式化金额;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeUtil {

	Connection conn = null;

	// 获取数据库连接
	public Connection getConn() {

		try {
			Class.forName( "net.sourceforge.jtds.jdbc.Driver" ); // 加载数据库驱动
		} catch ( ClassNotFoundException e ) {
			e.printStackTrace();
		}
		String url      = "jdbc:jtds:sqlserver://localhost:1433;DatabaseName=db_database21"; // 连接数据库URL
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

	public List getEmp() {

		List list = new ArrayList(); // 定义用于保存返回值的List集合
		conn = getConn(); // 获取数据库连接
		try {
			Statement staement = conn.createStatement();
			String    sql      = "select id,eName,convert( varchar(20),convert(money,oldEarning,1),1) as oldEarning from tb_employeePay"; // 定义查询数据的SQL语句
			ResultSet set      = staement.executeQuery( sql ); // 执行查询语句返回查询结果集
			while ( set.next() ) { // 循环遍历查询结果集
				EmployeePay pay = new EmployeePay();    //定义与数据库对应的JavaBean对象
				pay.setId( set.getInt( 1 ) );               //设置对象属性
				pay.seteName( set.getString( 2 ) );
				pay.setOldEarning( set.getString( 3 ) );
				list.add( pay );                          //将对象添加到集合中
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return list; // 返回List集合
	}

}
