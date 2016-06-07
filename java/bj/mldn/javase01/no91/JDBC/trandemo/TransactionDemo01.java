package bj.mldn.javase01.no91.JDBC.trandemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionDemo01 {

	// 驱动程序就是之前在classpath中配置的jdbc的驱动程序的jar包中
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	// 连接地址是由各个数据库生产商单独提供的，所以需要单独记住
	public static final String DBURL    = "jdbc:oracle:thin:@localhost:1521:MLDN";
	// 连接数据库的用户名
	public static final String DBUSER   = "scott";
	// 连接数据库的密码
	public static final String DBPASS   = "tiger";

	public static void main(String[] args) throws Exception {

		Connection conn = null; // 表示数据库的连接的对象
		Statement  stmt = null; // 表示数据库的更新操作
		// 1、使用Class类加载驱动程序
		Class.forName(DBDRIVER);
		// 2、连接数据库
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		// 3、Statement接口需要通过Connection接口进行实例化操作
		stmt = conn.createStatement();
		stmt.addBatch("INSERT INTO person(pid,name,age,birthday,salary) VALUES (perseq.nextval,'张三',30,TO_DATE('1995-02-14','yyyy-mm-dd'),9000.0) ");
		stmt.addBatch("INSERT INTO person(pid,name,age,birthday,salary) VALUES (perseq.nextval,'李四',30,TO_DATE('1995-02-14','yyyy-mm-dd'),9000.0) ");
		stmt.addBatch("INSERT INTO person(pid,name,age,birthday,salary) VALUES (perseq.nextval,'王五',30,TO_DATE('1995-02-14','yyyy-mm-dd'),9000.0) ");
		stmt.addBatch("INSERT INTO person(pid,name,age,birthday,salary) VALUES (perseq.nextval,'赵六',30,TO_DATE('1995-02-14','yyyy-mm-dd'),9000.0) ");
		stmt.addBatch("INSERT INTO person(pid,name,age,birthday,salary) VALUES (perseq.nextval,'孙七',30,TO_DATE('1995-02-14','yyyy-mm-dd'),9000.0) ");
		// 执行SQL语句，更新数据库
		int i[] = stmt.executeBatch();
		System.out.println(i.length);
		// 4、关闭数据库 
		stmt.close();
		conn.close();
	}
} 
