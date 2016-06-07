package bj.powernode.advance.Charpter19.dao;

import bj.powernode.advance.Charpter19.domain.Users;
import bj.powernode.advance.Charpter19.exception.MyException;
import bj.powernode.advance.Charpter19.util.JdbcUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// dao data access objec
// 在dao中完成JDBC的操作
// 在DAO中,把捕获的异常包装成一个运行时异常,传递给调用者
// 在Web开发中,底层的异常一定要报告给服务器才可以(使用运行时异常进行报告)
// Dao中的每个方法,只能包装一个单独的SQL语句!,是为了增强代码的复用性
public class UsersDao {

	public boolean validataUsers( Users user ) {

		boolean result = false;

		Connection        conn  = null;
		PreparedStatement pstat = null;
		ResultSet         res   = null;

		try {
			conn = JdbcUtil.getConnection();
			String sql = "SELECT * FROM USERS WHERE UPPER(name)=UPPER(?) and password=?";
			pstat = conn.prepareStatement( sql );
			pstat.setString( 1, user.getName() );
			pstat.setString( 2, user.getPassword() );

			res = pstat.executeQuery();
			if ( res.next() ) {
				result = true;
			}
		} catch ( SQLException e ) {
			throw new MyException( e );
		} catch ( ClassNotFoundException e ) {
			throw new MyException( e );
		} catch ( IOException e ) {
			throw new MyException( e );
		} finally {
			JdbcUtil.closeDb( res, pstat, conn );
		}
		return result;
	}
}
