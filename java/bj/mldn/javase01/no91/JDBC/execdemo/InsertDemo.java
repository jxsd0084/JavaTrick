package bj.mldn.javase01.no91.JDBC.execdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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

		Connection conn   = null; // 表示数据库的连接的对象
		Statement  stmt   = null; // 表示数据库的更新操作
		InputData  input  = new InputData();
		String     name   = input.getString("请输入姓名：");
		int        age    = input.getInt("请输入年龄：", "年龄必须是数字，");
		String     date   = input.getString("请输入生日：");
		float      salary = input.getFloat("请输入工资：", "输入的工资必须是数字，");
		String sql = "INSERT INTO person(pid,name,age,birthday,salary) VALUES (perseq.nextval,'"
		             + name + "'," + age + ",TO_DATE('"
		             + date + "','yyyy-mm-dd')," + salary + ") ";
		System.out.println(sql);
		// 1、使用Class类加载驱动程序
		Class.forName(DBDRIVER);
		// 2、连接数据库
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		// 3、Statement接口需要通过Connection接口进行实例化操作
		stmt = conn.createStatement();
		// 执行SQL语句，更新数据库
		stmt.executeUpdate(sql);
		// 4、关闭数据库 
		conn.close();
	}
}
