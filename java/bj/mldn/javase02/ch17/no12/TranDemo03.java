package bj.mldn.javase02.ch17.no12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

public class TranDemo03 {

	// 定义MySQL的数据库驱动程序
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	// 定义MySQL数据库的连接地址
	public static final String DBURL    = "jdbc:mysql://localhost:3306/mldn";
	// MySQL数据库的连接用户名
	public static final String DBUSER   = "root";
	// MySQL数据库的连接密码
	public static final String DBPASS   = "mysqladmin";

	/**
	 * 测试
	 * @param args
	 * @throws Exception
	 */
	public static void main( String args[] ) throws Exception {    // 所有异常抛出
		Connection conn = null;        // 数据库连接
		Statement  stmt = null;        // 定义数据库操作
		Class.forName( DBDRIVER );     // 加载驱动程序
		conn = DriverManager.getConnection( DBURL, DBUSER, DBPASS );

		conn.setAutoCommit( false );   // 取消掉自动提交

		stmt = conn.createStatement();
		stmt.executeUpdate( "INSERT INTO user(name,password,age,sex,birthday)" +
		                    " VALUES ('LXH-1','hello-1',11,'男','1975-03-05') " );
		stmt.executeUpdate( "INSERT INTO user(name,password,age,sex,birthday)" +
		                    " VALUES ('LXH-2','hello-2',12,'女','1976-03-05') " );
		Savepoint sp = conn.setSavepoint();        // 设置保存点

		stmt.executeUpdate( "INSERT INTO user(name,password,age,sex,birthday)" +
		                    " VALUES ('LXH-4','hello-4',14,'女','1965-03-05') " );
		stmt.executeUpdate( "INSERT INTO user(name,password,age,sex,birthday)" +
		                    " VALUES ('LXH-5','hello-5',15,'女','1965-08-05') " );
		try {
			conn.rollback( sp );    // 回滚到保存点
			conn.commit();    // 所有的操作成功了
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		stmt.close();
		conn.close();            // 数据库关闭
	}
}
