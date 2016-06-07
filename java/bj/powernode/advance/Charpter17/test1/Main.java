package bj.powernode.advance.Charpter17.test1;

import java.sql.*;

public class Main {

	public void selectByOracle() {

		Connection conn = null;
		Statement  stat = null;
		ResultSet  res  = null;

		try {
			// 把驱动类向Drivermanager注册
			// Class.forName(driver);
			// Class.forName(driver1);

			// new oracle.jdbc.OracleDriver();
			// new com.mysql.jdbc.Driver();

			// DriverManager.getConnection返回的是什么?
			// 是一个实现了Connection接口的类的对象
			// conn = DriverManager.getConnection(url, user, password);

			conn = JdbcUtil.getConnection();

			// conn.createStatement()返回的是实现了Statement接口的类的对象
			stat = conn.createStatement();
			String sql = "SELECT  DEPTNO ,MAX(SAL)  MAXSAL FROM EMP WHERE DEPTNO IS NOT NULL GROUP BY DEPTNO";

			res = stat.executeQuery( sql );

			while ( res.next() ) {
				// int empno = res.getInt(2);
				// // int empno = res.getInt("EMPNO");
				// String ename = res.getString(1);
				// String job = res.getString(3);
				// int mgr = res.getInt(4);
				// java.sql.Date hiredate = res.getDate(5);
				// double sal = res.getDouble(6);
				// double comm = res.getDouble(7);
				// int deptno = res.getInt(8);
				//
				// System.out.println(empno + " " + ename + " " + job + " " +
				// mgr
				// + " " + hiredate + " " + sal + " " + comm + " "
				// + deptno);

				// int deptno = res.getInt(1);
				// double maxSal = res.getDouble(2);

				int    deptno = res.getInt( "DEPTNO" );
				double maxSal = res.getDouble( "MAXSAL" );

				System.out.println( deptno + " " + maxSal );
			}
		}

		// catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeDb( res, stat, conn );
		}
	}

	public void selectByMySql() {

		Connection conn = null;
		Statement  stat = null;
		ResultSet  res  = null;

		try {
			// Class.forName(driver);
			// DriverManager.getConnection返回的是什么?
			// 是一个实现了Connection接口的类的对象
			// conn = DriverManager.getConnection(url, user, password);

			// conn.createStatement()返回的是实现了Statement接口的类的对象
			conn = JdbcUtil.getConnection();
			stat = conn.createStatement();
			String sql = "SELECT * FROM USERS";

			res = stat.executeQuery( sql );

			while ( res.next() ) {
				int    id       = res.getInt( 1 );
				String name     = res.getString( 2 );
				double sal      = res.getDouble( 3 );
				Date   hiredate = res.getDate( 4 );

				System.out
						.println( id + " " + name + " " + sal + " " + hiredate );
			}
		}
		// catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeDb( res, stat, conn );
		}
	}

	public void selectByOracleOdbc() {

		Connection conn = null;
		Statement  stat = null;
		ResultSet  res  = null;

		// InputStream in =
		// this.getClass().getClassLoader().getResourceAsStream(
		// "db.properties");

		try {
			// Class.forName(driver2);
			// DriverManager.getConnection返回的是什么?
			// 是一个实现了Connection接口的类的对象
			// conn = DriverManager.getConnection(url2, user2, password2);

			// conn.createStatement()返回的是实现了Statement接口的类的对象

			conn = JdbcUtil.getConnection();
			stat = conn.createStatement();
			String sql = "SELECT  DEPTNO ,MAX(SAL)  MAXSAL FROM EMP WHERE DEPTNO IS NOT NULL GROUP BY DEPTNO";

			res = stat.executeQuery( sql );

			while ( res.next() ) {
				int    deptno = res.getInt( "DEPTNO" );
				double maxSal = res.getDouble( "MAXSAL" );

				System.out.println( deptno + " " + maxSal );
			}
		}
		// catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeDb( res, stat, conn );
		}
	}

	public void insertEmp() {

		Connection conn = null;
		Statement  stat = null;
		ResultSet  res  = null;

		conn = JdbcUtil.getConnection();
		try {
			// 设置不自动提交事务
			conn.setAutoCommit( false );
			stat = conn.createStatement();

			// 在JDBC中使用DML语句,事务是默认提交的
			String sql    = "INSERT INTO EMP VALUES(8001,'张三','工程师',7698,TO_DATE('1987-12-23','YYYY-MM-DD'),3000.00,2000,20)";
			int    result = stat.executeUpdate( sql );

			if ( result > 0 ) {
				System.out.println( "插入数据成功" );
			} else {
				System.out.println( "插入数据失败" );
			}
			conn.commit();
		} catch ( SQLException e ) {
			System.out.println( "SQL语句遇到异常" );
			try {
				conn.rollback();
			} catch ( SQLException e1 ) {

				e1.printStackTrace();
			}
		} finally {
			JdbcUtil.closeDb( null, stat, conn );
		}
	}

	public void insertEmp1() {

		Connection conn = null;
		Statement  stat = null;
		ResultSet  res  = null;

		conn = JdbcUtil.getConnection();
		try {
			// 设置不自动提交事务
			conn.setAutoCommit( false );
			stat = conn.createStatement();

			// 在JDBC中使用DML语句,事务是默认提交的
			String sql    = "INSERT INTO EMP VALUES(8002,'张三','工程师',7698,TO_DATE('1987-12-23','YYYY-MM-DD'),3000.00,2000,20)";
			int    result = stat.executeUpdate( sql );

			sql = "INSERT INTO EMP VALUES(8003,'张三','工程师',7698,TO_DATE('1987-12-23','YYYY-MM-DD'),3000.00,2000,20)";
			stat.executeUpdate( sql );

			sql = "INSERT INTO EMP VALUES(8004,'张三','工程师',7698,TO_DATE('1987-12-23','YYYY-MM-DD'),3000.00,2000)";
			stat.executeUpdate( sql );

			// if (result > 0) {
			// System.out.println("插入数据成功");
			// } else {
			// System.out.println("插入数据失败");
			// }
			conn.commit();

			System.out.println( "OK" );
		} catch ( SQLException e ) {
			System.out.println( "SQL语句遇到异常" );
			try {
				conn.rollback();
			} catch ( SQLException e1 ) {

				e1.printStackTrace();
			}
			// e.printStackTrace();
		} finally {
			JdbcUtil.closeDb( null, stat, conn );
		}
	}

	public void insertEmp12() {

		Connection conn = null;
		Statement  stat = null;
		ResultSet  res  = null;

		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit( false );
			stat = conn.createStatement();

			String sql = "INSERT INTO EMP VALUES(8000,'张三','工程师',7698,TO_DATE('1987-12-23','YYYY-MM-DD'),3000.00,2000,20)";
			stat.addBatch( sql );

			sql = "INSERT INTO EMP VALUES(8001,'张三','工程师',7698,TO_DATE('1987-12-23','YYYY-MM-DD'),3000.00,2000,20)";
			stat.addBatch( sql );

			sql = "INSERT INTO EMP VALUES(8002,'张三','工程师',7698,TO_DATE('1987-12-23','YYYY-MM-DD'),3000.00,2000,20)";
			stat.addBatch( sql );

			stat.executeBatch();

			System.out.println( "批量插入数据成功!" );

		} catch ( SQLException e ) {
			try {
				conn.rollback();
			} catch ( SQLException e1 ) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			JdbcUtil.closeDb( null, stat, conn );
		}
	}

	public static void main( String[] args ) {

		new Main().insertEmp12();
		// new Main().selectByMySql();
		// new Main().selectByOracleOdbc();
	}

}
