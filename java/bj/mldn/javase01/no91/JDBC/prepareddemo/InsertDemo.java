package bj.mldn.javase01.no91.JDBC.prepareddemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

public class InsertDemo {

	// 驱动程序就是之前在classpath中配置的jdbc的驱动程序的jar包中
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	// 连接地址是由各个数据库生产商单独提供的，所以需要单独记住
	public static final String DBURL    = "jdbc:oracle:thin:@localhost:1521:MLDN";
	// 连接数据库的用户名
	public static final String DBUSER   = "scott";
	// 连接数据库的密码
	public static final String DBPASS   = "tiger";

	public static void main(String[] args) throws Exception {

		Connection        conn   = null; // 表示数据库的连接的对象
		PreparedStatement pstmt  = null; // 表示数据库的更新操作
		InputData         input  = new InputData();
		String            name   = input.getString("请输入姓名：");
		int               age    = input.getInt("请输入年龄：", "年龄必须是数字，");
		Date              date   = input.getDate("请输入生日：", "输入的不是日期，");
		float             salary = input.getFloat("请输入工资：", "输入的工资必须是数字，");
		String            sql    = "INSERT INTO person(pid,name,age,birthday,salary) VALUES (perseq.nextval,?,?,?,?) ";
		System.out.println(sql);
		// 1、使用Class类加载驱动程序
		Class.forName(DBDRIVER);
		// 2、连接数据库
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		// 3、PreparedStatement接口需要通过Connection接口进行实例化操作
		pstmt = conn.prepareStatement(sql);// 使用预处理的方式创建对象
		pstmt.setString(1, name);// 第一个？号的内容
		pstmt.setInt(2, age);    // 第二个？号的内容
		pstmt.setDate(3, new java.sql.Date(date.getTime()));
		pstmt.setFloat(4, salary);
		// 执行SQL语句，更新数据库
		pstmt.executeUpdate();
		// 4、关闭数据库 
		pstmt.close();
		conn.close();
	}
}
