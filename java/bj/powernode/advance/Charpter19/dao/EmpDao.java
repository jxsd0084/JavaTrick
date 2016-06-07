package bj.powernode.advance.Charpter19.dao;

import bj.powernode.advance.Charpter19.domain.Emp;
import bj.powernode.advance.Charpter19.domain.EmpPage;
import bj.powernode.advance.Charpter19.exception.MyException;
import bj.powernode.advance.Charpter19.util.JdbcUtil;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmpDao {

	public boolean insertEmp( Emp emp ) throws SQLException {

		boolean result = false;

		Connection        conn  = null;
		PreparedStatement pstat = null;

		try {
			conn = JdbcUtil.getConnection();
			// String sql =
			// "INSERT INTO EMP VALUES (8000,'张三','工程师',7698, '12-12月-1987',3000.0,2000.0,30)";
			String sql = "INSERT INTO EMP VALUES (?,      ? ,    ? ,?   , ?,             ?,    ?,      ?)";
			pstat = conn.prepareStatement( sql );
			pstat.setInt( 1, emp.getEmpno() );
			pstat.setString( 2, emp.getEname() );
			pstat.setString( 3, emp.getJob() );
			pstat.setInt( 4, emp.getMgr() );
			pstat.setDate( 5, emp.getHiredate() );
			pstat.setDouble( 6, emp.getSal() );
			pstat.setDouble( 7, emp.getComm() );
			pstat.setInt( 8, emp.getDeptno() );

			int res = pstat.executeUpdate();
			if ( res > 0 ) {
				result = true;
			}
		} catch ( ClassNotFoundException e ) {
			throw new MyException( e );
		} catch ( SQLException e ) {
			throw e;
		} catch ( IOException e ) {
			throw new MyException( e );
		} finally {
			JdbcUtil.closeDb( null, pstat, conn );
		}

		return result;
	}

	public boolean deleteByEmpno( int empno ) {

		boolean result = false;

		Connection        conn  = null;
		PreparedStatement pstat = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "DELETE FROM EMP WHERE EMPNO=?";
			pstat = conn.prepareCall( sql );
			pstat.setInt( 1, empno );

			if ( pstat.executeUpdate() > 0 ) {
				result = true;
			}

		} catch ( ClassNotFoundException e ) {
			throw new MyException( e );
		} catch ( SQLException e ) {
			throw new MyException( e );
		} catch ( IOException e ) {
			throw new MyException( e );
		} finally {
			JdbcUtil.closeDb( null, pstat, conn );
		}
		return result;
	}

	public List< Emp > searchEmp( Emp emp ) throws SQLException {

		List< Emp > list = new LinkedList< Emp >();
		Connection  conn = null;
		Statement   stat = null;
		ResultSet   res  = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = this.getSearchEmpSql( emp );
			stat = conn.createStatement();
			res = stat.executeQuery( sql );

			while ( res.next() ) {
				Emp e = new Emp();
				e.setEmpno( res.getInt( 1 ) );
				e.setEname( res.getString( 2 ) );
				e.setJob( res.getString( 3 ) );
				e.setMgr( res.getInt( 4 ) );
				e.setHiredate( res.getDate( 5 ) );
				e.setSal( res.getDouble( 6 ) );
				e.setComm( res.getDouble( 7 ) );
				e.setDeptno( res.getInt( 8 ) );

				list.add( e );
			}
		} catch ( ClassNotFoundException e ) {
			throw new MyException( e );
		} catch ( SQLException e ) {
			throw e;
		} catch ( IOException e ) {
			throw new MyException( e );
		} finally {
			JdbcUtil.closeDb( res, stat, conn );
		}

		return list;
	}

	private String getSearchEmpSql( Emp emp ) {

		StringBuffer strb = new StringBuffer( "SELECT * FROM EMP WHERE 1=1 " );
		if ( emp.getEmpno() != - 1 ) {
			strb.append( " AND EMPNO =" + emp.getEmpno() );
		}

		if ( emp.getEname() != null && emp.getEname().length() > 0 ) {
			strb.append( " AND ENAME LIKE '%" + emp.getEname() + "%' " );
		}

		if ( emp.getJob() != null && emp.getJob().length() > 0 ) {
			strb.append( " AND JOB = '" + emp.getJob() + "' " );
		}

		// 继续拼接其他的条件

		return strb.toString();
	}

	/**
	 * 为了分页,首先要查询符合条件的数据的总条数
	 *
	 * @param emp 查询的条件
	 * @return 符合条件的数据的条数
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int getTotalNum( Emp emp ) throws ClassNotFoundException, SQLException, IOException {

		int totalNum = 0;

		Connection conn = null;
		Statement  stat = null;
		ResultSet  res  = null;

		try {
			conn = JdbcUtil.getConnection();
			stat = conn.createStatement();
			String sql = this.getTotalNumSql( emp );
			res = stat.executeQuery( sql );

			if ( res.next() ) {
				totalNum = res.getInt( 1 );
			}
		} finally {
			JdbcUtil.closeDb( res, stat, conn );
		}
		return totalNum;
	}

	/**
	 * 为了实现分页功能,查询符合条件的部分数据
	 *
	 * @param emp 查询的条件
	 * @return 装载符合条件的部分数据的集合
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List< Emp > searchPageEmp( Emp emp, int currentPage ) throws ClassNotFoundException, SQLException, IOException {

		List< Emp > list = new LinkedList< Emp >();

		Connection conn = null;
		Statement  stat = null;
		ResultSet  res  = null;

		try {
			conn = JdbcUtil.getConnection();
			int from = ( currentPage - 1 ) * EmpPage.itemPerPage + 1;
			int to   = currentPage * EmpPage.itemPerPage;

			String sql = this.getsearchPageEmpSql( emp, from, to );
			stat = conn.createStatement();
			res = stat.executeQuery( sql );

			while ( res.next() ) {
				Emp e = new Emp();
				e.setEmpno( res.getInt( 2 ) );
				e.setEname( res.getString( 3 ) );
				e.setJob( res.getString( 4 ) );
				e.setMgr( res.getInt( 5 ) );
				e.setHiredate( res.getDate( 6 ) );
				e.setSal( res.getDouble( 7 ) );
				e.setComm( res.getDouble( 8 ) );
				e.setDeptno( res.getInt( 9 ) );

				list.add( e );
			}
		} finally {
			JdbcUtil.closeDb( res, stat, conn );
		}

		return list;
	}

	private String getsearchPageEmpSql( Emp emp, int from, int to ) {

		StringBuffer strb = new StringBuffer(
				"SELECT  EE.* FROM (SELECT ROWNUM RN, E.* FROM EMP E   WHERE 1=1 " );
		if ( emp.getEmpno() != - 1 ) {
			strb.append( " AND EMPNO =" + emp.getEmpno() );
		}

		if ( emp.getEname() != null ) {
			strb.append( " AND ENAME LIKE '%" + emp.getEname() + "%'" );
		}

		if ( emp.getJob() != null ) {
			strb.append( " AND JOB ='" + emp.getJob() + "'" );
		}

		if ( emp.getMgr() != - 1 ) {
			strb.append( " AND MGR=" + emp.getMgr() );
		}

		if ( emp.getHiredate() != null ) {
			strb.append( " AND HIREDATE = TO_DATE('" + emp.getHiredate()
			             + "','yyyy-MM-dd') " );
		}

		strb.append( ") EE  WHERE RN >=" + from + " AND RN <=" + to );

		return strb.toString();
	}

	private String getTotalNumSql( Emp emp ) {

		StringBuffer strb = new StringBuffer(
				"SELECT COUNT(*)FROM EMP WHERE 1=1 " );
		if ( emp.getEmpno() != - 1 ) {
			strb.append( " AND EMPNO =" + emp.getEmpno() );
		}

		if ( emp.getEname() != null ) {
			strb.append( " AND ENAME LIKE '%" + emp.getEname() + "%'" );
		}

		if ( emp.getJob() != null ) {
			strb.append( " AND JOB ='" + emp.getJob() + "'" );
		}

		if ( emp.getMgr() != - 1 ) {
			strb.append( " AND MGR=" + emp.getMgr() );
		}

		if ( emp.getHiredate() != null ) {
			strb.append( " AND HIREDATE = TO_DATE('" + emp.getHiredate()
			             + "','yyyy-MM-dd') " );
		}
		return strb.toString();
	}

	public static void main( String[] args ) {

		Date date = Date.valueOf( "1987-2-12" );
		Emp  emp  = new Emp();
		emp.setHiredate( date );
		String sql = new EmpDao().getsearchPageEmpSql( emp, 1, 5 );
		System.out.println( sql );
	}
}
