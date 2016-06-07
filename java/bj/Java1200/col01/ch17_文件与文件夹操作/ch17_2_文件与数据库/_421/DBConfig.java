package bj.Java1200.col01.ch17_文件与文件夹操作.ch17_2_文件与数据库._421;

public interface DBConfig {

	// 设置JDBC基本信息，使用的是MySQL数据库。
	String URL      = "jdbc:mysql://localhost:3306/db_database17";

	String DRIVER   = "com.mysql.jdbc.Driver";

	String USERNAME = "root";

	String PASSWORD = "111";
}
