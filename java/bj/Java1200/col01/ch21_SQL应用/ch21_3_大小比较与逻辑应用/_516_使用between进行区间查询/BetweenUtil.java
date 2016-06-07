package bj.Java1200.col01.ch21_SQL应用.ch21_3_大小比较与逻辑应用._516_使用between进行区间查询;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BetweenUtil {

	// 获取数据库连接
	private Connection conn;

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

	// 定义按指定按指定条件降序查询数据方法

	public List getGrade() {

		List list = new ArrayList(); // 定义用于保存返回值的List集合
		conn = getConn(); // 获取数据库连接
		try {
			Statement staement = conn.createStatement();
			String    sql      = "select name,english from tb_Grade  where english  between 80 and 90"; // 定义查询英文成绩在80到9之间的学生信息SQL语句
			ResultSet set      = staement.executeQuery( sql ); // 执行查询语句返回查询结果集
			while ( set.next() ) { // 循环遍历查询结果集
				Grade grade = new Grade(); // 创建于学生成绩表对应的Grade对象
				grade.setName( set.getString( 1 ) );
				grade.setEnglish( set.getFloat( 2 ) );
				list.add( grade ); // 将Grade对象添加到集合中
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return list; // 返回查询集合
	}

	public static void main( String[] args ) {

		BetweenUtil util = new BetweenUtil();
		List        list = util.getGrade();
		System.out.println( "查询英语成绩在80与90之间的学生：" );
		for ( int i = 0; i < list.size(); i++ ) {
			Grade grade = ( Grade ) list.get( i );
			System.out.println( "姓名：" + grade.getName() + " ，英语成绩：" + grade.getEnglish() );
		}
	}

}
