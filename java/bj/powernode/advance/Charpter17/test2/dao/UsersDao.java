package bj.powernode.advance.Charpter17.test2.dao;

import bj.powernode.advance.Charpter17.test1.JdbcUtil;
import bj.powernode.advance.Charpter17.test2.domain.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// 在dao中执行数据库的访问操作!
public class UsersDao {

	/**
	 * 判断输入的用户是否是有效的用户
	 *
	 * @param user 输入的用户
	 * @return 是否是有效的用户
	 */
	public boolean login( Users user ) {
		// boolean result = false;
		// Connection conn = null;
		// Statement stat = null;
		// ResultSet res = null;
		//
		// try {
		// conn = JdbcUtil.getConnection();
		// stat = conn.createStatement();
		//
		// String sql = "SELECT * FROM USERS WHERE NAME ='" + user.getName()
		// + "' AND PASSWORD='" + user.getPassword() + "'";
		// res = stat.executeQuery(sql);
		//
		// if (res.next()) {
		// result = true;
		// }
		//
		// } catch (SQLException e) {
		// e.printStackTrace();
		// } finally {
		// JdbcUtil.closeDb(res, stat, conn);
		// }
		//
		// return result;

		boolean           result = false;
		Connection        conn   = null;
		PreparedStatement pstat  = null;
		ResultSet         res    = null;

		try {
			conn = JdbcUtil.getConnection();

			String sql = "SELECT * FROM USERS WHERE NAME =? AND PASSWORD=?";
			pstat = conn.prepareStatement( sql );
			pstat.setString( 1, user.getName() );
			pstat.setString( 2, user.getPassword() );

			res = pstat.executeQuery();
			if ( res.next() ) {
				result = true;
			}

		} catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeDb( res, pstat, conn );
		}
		return result;
	}

	/**
	 * 添加新用户到数据库
	 *
	 * @param user 要添加的用户
	 * @return 添加用户是否成功!
	 */
	public boolean insertUsers( Users user ) {
		// boolean result = false;
		// Connection conn = null;
		// Statement stat = null;
		//
		// try {
		// conn = JdbcUtil.getConnection();
		// stat = conn.createStatement();
		// String sql = "INSERT INTO USERS VALUES (PK_USERS.NEXTVAL,'"
		// + user.getName() + "','" + user.getSex() + "','"
		// + user.getPassword() + "',TO_DATE('" + user.getBirthday()
		// + "','YYYY-MM-DD'))";
		//
		// int i = stat.executeUpdate(sql);
		// if (i > 0) {
		// result = true;
		// }
		//
		// } catch (SQLException e) {
		//
		// e.printStackTrace();
		// } finally {
		// JdbcUtil.closeDb(null, stat, conn);
		// }
		//
		// return result;

		boolean           result = false;
		Connection        conn   = null;
		PreparedStatement pstat  = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "INSERT INTO  USERS (name,sex,password,birthday) VALUES (?,?,?,?)";
			pstat = conn.prepareStatement( sql );
			pstat.setString( 1, user.getName() );
			pstat.setString( 2, user.getSex() );
			pstat.setString( 3, user.getPassword() );
			pstat.setDate( 4, user.getBirthday() );

			int i = pstat.executeUpdate();
			if ( i > 0 ) {
				result = true;
			}

		} catch ( SQLException e ) {

			e.printStackTrace();
		} finally {
			JdbcUtil.closeDb( null, pstat, conn );
		}

		return result;
	}

	public void batchInsert( List< Users > list ) {

		boolean           result = false;
		Connection        conn   = null;
		PreparedStatement pstat  = null;

		try {
			conn = JdbcUtil.getConnection();
			conn.setAutoCommit( false );
			String sql = "INSERT INTO  USERS (id, name,sex,password,birthday) VALUES (PK_USERS.NEXTVAL,?,?,?,?)";
			pstat = conn.prepareStatement( sql );

			for ( Users u : list ) {
				pstat.setString( 1, u.getName() );
				pstat.setString( 2, u.getSex() );
				pstat.setString( 3, u.getPassword() );
				pstat.setDate( 4, u.getBirthday() );

				pstat.addBatch();
			}

			int[] arr = pstat.executeBatch();

			conn.commit();
			System.out.println( "批量插入数据成功!" );

		} catch ( SQLException e ) {
			System.out.println( "批量插入遇到异常" );
			try {
				conn.rollback();
			} catch ( SQLException e1 ) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtil.closeDb( null, pstat, conn );
		}
	}
}
