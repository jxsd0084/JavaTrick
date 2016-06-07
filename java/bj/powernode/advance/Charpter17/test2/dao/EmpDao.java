package bj.powernode.advance.Charpter17.test2.dao;

import bj.powernode.advance.Charpter17.test1.JdbcUtil;
import bj.powernode.advance.Charpter17.test3.ConnectionPool;

import java.sql.*;

public class EmpDao {

	public void selectEmp() {

		Connection     conn = null;
		Statement      stat = null;
		ResultSet      res  = null;

		ConnectionPool pool = ConnectionPool.getConnectionPool();

		try {
			//conn = JdbcUtil.getConnection();

			conn = pool.getConnection();

			String sql = "SELECT * FROM EMP ORDER BY EMPNO";
			stat = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
			                             ResultSet.CONCUR_READ_ONLY );

			res = stat.executeQuery( sql );

			// res.absolute(3);
			// int empno = res.getInt(1);
			// String ename = res.getString(2);
			// String job = res.getString(3);
			// int mgr = res.getInt(4);
			// java.sql.Date hiredate = res.getDate(5);
			// double sal = res.getDouble(6);
			// double comm = res.getDouble(7);
			// int deptno = res.getInt(8);

			// System.out.println(empno + " " + ename + " " + job + " " + mgr
			// + " " + hiredate + " " + sal + " " + comm + " " + deptno);

			res.afterLast();
			while ( res.previous() ) {
				int    empno    = res.getInt( 1 );
				String ename    = res.getString( 2 );
				String job      = res.getString( 3 );
				int    mgr      = res.getInt( 4 );
				Date   hiredate = res.getDate( 5 );
				double sal      = res.getDouble( 6 );
				double comm     = res.getDouble( 7 );
				int    deptno   = res.getInt( 8 );

				System.out.println( empno + " " + ename + " " + job + " " + mgr
				                    + " " + hiredate + " " + sal + " " + comm + " "
				                    + deptno );
			}

			int size = pool.getUseableConn();
			System.out.println( "连接池中还有连接数:" + size );

		} catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			pool.returnConn( conn );
			int size = pool.getUseableConn();
			System.out.println( "连接池中还有连接数:" + size );
			//JdbcUtil.closeDb(res, stat, conn);
		}
	}

	public void updateBySelect() {

		Connection conn = null;
		Statement  stat = null;
		ResultSet  res  = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "SELECT EMP.* FROM EMP ORDER BY EMPNO";
			stat = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
			                             ResultSet.CONCUR_UPDATABLE );

			res = stat.executeQuery( sql );

			res.absolute( 3 );
			int    empno    = res.getInt( 1 );
			String ename    = res.getString( 2 );
			String job      = res.getString( 3 );
			int    mgr      = res.getInt( 4 );
			Date   hiredate = res.getDate( 5 );
			double sal      = res.getDouble( 6 );
			double comm     = res.getDouble( 7 );
			int    deptno   = res.getInt( 8 );

			System.out.println( empno + " " + ename + " " + job + " " + mgr
			                    + " " + hiredate + " " + sal + " " + comm + " " + deptno );

			res.updateString( 2, "张三" );

			res.updateRow();

			// res.afterLast();
			// while (res.previous()) {
			// int empno = res.getInt(1);
			// String ename = res.getString(2);
			// String job = res.getString(3);
			// int mgr = res.getInt(4);
			// java.sql.Date hiredate = res.getDate(5);
			// double sal = res.getDouble(6);
			// double comm = res.getDouble(7);
			// int deptno = res.getInt(8);
			//
			// System.out.println(empno + " " + ename + " " + job + " " + mgr
			// + " " + hiredate + " " + sal + " " + comm + " "
			// + deptno);
			// }

		} catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeDb( res, stat, conn );
		}
	}

	public void meatDataTest() {

		Connection conn = null;
		Statement  stat = null;
		ResultSet  res  = null;

		try {
			conn = JdbcUtil.getConnection();
			DatabaseMetaData dm = conn.getMetaData();
			System.out.println( dm.getDatabaseProductName() + "\n"
			                    + dm.getDatabaseProductVersion() + "\n" + dm.getURL()
			                    + "\n" + dm.getUserName() );

			String sql = "SELECT EMP.* FROM EMP ORDER BY EMPNO";
			stat = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
			                             ResultSet.CONCUR_UPDATABLE );

			res = stat.executeQuery( sql );

			ResultSetMetaData rm = res.getMetaData();
			for ( int i = 1; i <= rm.getColumnCount(); i++ ) {
				System.out.println( rm.getColumnName( i ) + "  "
				                    + rm.getColumnTypeName( i ) );
			}

		} catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeDb( res, stat, conn );
		}
	}
}
