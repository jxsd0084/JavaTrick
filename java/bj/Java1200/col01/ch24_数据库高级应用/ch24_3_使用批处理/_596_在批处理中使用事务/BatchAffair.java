package bj.Java1200.col01.ch24_数据库高级应用.ch24_3_使用批处理._596_在批处理中使用事务;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BatchAffair {

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

	//获取全部用户编号方法
	public List selectIds() {

		conn = getConn(); // 获取数据库连接
		Statement cs   = null; // 定义CallableStatement对象
		String    sql  = "Select accoutNumber from tb_transition"; // 定义查询视图的SQL语句
		List      list = new ArrayList(); // 定义保存查询结果的List集合
		try {
			cs = conn.createStatement(); // 实例化Statement对象
			ResultSet rest = cs.executeQuery( sql ); // 执行SQL语句
			while ( rest.next() ) { // 循环遍历查询结果集
				String accoutNumber = rest.getString( 1 );
				list.add( accoutNumber );
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return list;
	}
	//设置转账方法

	public void Batch( String incomeId, String goId, float money ) throws SQLException {

		try {
			conn = getConn(); // 获取数据库连接
			boolean autoCommit = conn.getAutoCommit();
			conn.setAutoCommit( false );

			Statement cs = null; // 定义Statement对象
			cs = conn.createStatement(); // 实例化Statement对象
			cs.addBatch( "update tb_transition set deposit = deposit-" + money
					+ " ,transition = transition-" + money
					+ " where accoutNumber = " + goId );             //定义修改转账表中数据方法
			cs.addBatch( "update tb_transition set deposit = deposit+" + money
					+ " ,shift = shift+" + money + " where accoutNumber = "
					+ incomeId );
			cs.executeBatch(); // 批量执行SQL语句
			cs.close(); // 将Statement对象关闭
			conn.commit();
			conn.setAutoCommit( autoCommit );
			conn.close();
		} catch ( Exception e ) {
			conn.rollback();
			e.printStackTrace();
		}
	}

}
